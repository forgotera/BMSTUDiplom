package ru.skillbranch.places.secectScreen

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.R

class SelectHolder(
    view: View,
    private val text:TextView,
    private val image:ImageView
):RecyclerView.ViewHolder(view) {

    fun bind(name:String,url:String){
        text.text = name
        image.setImageResource(R.drawable.test)
    }
}

fun Context.selectHolder(view:View):SelectHolder =
    SelectHolder(
        view,
        view.findViewById(R.id.selectText),
        view.findViewById(R.id.selectIcon)
    )