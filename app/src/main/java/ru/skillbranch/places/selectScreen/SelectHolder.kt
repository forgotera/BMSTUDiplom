package ru.skillbranch.places.selectScreen

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.R

class SelectHolder(
    private val view: View,
    private val cardView: CardView,
    private val text: TextView,
    private val image: ImageView,
    private val onClick: ((String) -> Unit)?
) : RecyclerView.ViewHolder(view) {

    fun bind(name: String, url: String) {
        view.setOnClickListener {
            onClick?.invoke("")
        }
        text.text = name
        image.setImageResource(R.drawable.test)
    }
}

fun Context.selectHolder(view: View, onClick: ((String) -> Unit)?): SelectHolder =
    SelectHolder(
        view,
        view.findViewById(R.id.selectCardView),
        view.findViewById(R.id.selectText),
        view.findViewById(R.id.selectIcon),
        onClick
    )
