package ru.skillbranch.places.component

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import ru.skillbranch.places.R
import ru.skillbranch.places.drawable.borderDrawable
import ru.skillbranch.places.drawable.insetBottomDrawable
import ru.skillbranch.places.drawable.topCorners
import ru.skillbranch.places.utils.dip
import ru.skillbranch.places.utils.layerDrawable
import timber.log.Timber

class PlaceView : FrameLayout {


    companion object {
        private const val CORNER = 20
        private const val SHADOW = 5
    }
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )


    private val headerView by lazy { findViewById<TextView>(R.id.viewPagerHeader) }
    private val imageView by lazy { findViewById<ImageView>(R.id.viewPagerImage) }
    private val urlView by lazy { findViewById<TextView>(R.id.viewPagerTextUrl) }
    private val addressView by lazy { findViewById<TextView>(R.id.viewPagerTextPlace) }


    override fun onFinishInflate() {
        super.onFinishInflate()
        LayoutInflater.from(context).inflate(R.layout.place_view, this)
        initialization()
    }


    private fun initialization() {
//        setBackgroundColor(Color.WHITE)
       setBackgroundDrawable(context.borderDrawable(context.dip(20), Color.BLACK))

    }

    private fun topContainerDrawable(): Drawable = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> topCorners(
            context.dip(CORNER).toFloat(),
            Color.WHITE
        )
        else                                                  -> layerDrawable(
            topCorners(
                context.dip(CORNER).toFloat(),
                Color.parseColor("#1A000000")
            ),
            insetBottomDrawable(
                topCorners(context.dip(CORNER).toFloat(), Color.WHITE),
                inset = -context.dip(2)
            )
        )
    }
    var header: String? = ""
        set(value) {
            field = value
            headerView.text = value
        }

    var imageResource: Int? = null
        set(value) {
            field = value
            imageResource?.let { imageView.setImageResource(it) }
        }

    var url: String? = ""
        set(value) {
            field = value
            urlView.text = url
        }

    var address: String? = ""
        set(value) {
            field = value
            addressView.text = address
        }

}
