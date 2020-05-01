package ru.skillbranch.places.screens.selectScreen.presentation

import android.content.Context
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

    fun bind(name: String, url: Int) {
        view.setOnClickListener {
            onClick?.invoke(name)
        }
        text.text = name
        image.setImageResource(url)
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
