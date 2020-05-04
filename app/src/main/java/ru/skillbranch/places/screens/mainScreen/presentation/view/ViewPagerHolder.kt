package ru.skillbranch.places.screens.mainScreen.presentation.view

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.R

class ViewPagerHolder(
    private val view: View,
    private val header:TextView,
    private val image:ImageView,
    private val info:TextView,
    private val address:TextView,
    private val onClick: (() -> Unit)?
):RecyclerView.ViewHolder(view){

    fun bind(header: String,image:Int,info:String,address: String){
        view.setOnClickListener{
            onClick?.invoke()
        }

        this.header.text = header
        this.image.setImageResource(image)
        this.info.text = info
        this.address.text = address
    }
}


fun Context.viewPagerHolder(view:View,onClick:(() -> Unit)?):ViewPagerHolder =
    ViewPagerHolder(
        view,
        view.findViewById(R.id.viewPagerHeader),
        view.findViewById(R.id.viewPagerImage),
        view.findViewById(R.id.viewPagerTextInfo),
        view.findViewById(R.id.viewPagerTextPlace),
        onClick
    )