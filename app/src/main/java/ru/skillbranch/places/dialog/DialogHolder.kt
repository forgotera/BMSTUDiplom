package ru.skillbranch.places.dialog

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import ru.skillbranch.places.R

class DialogHolder(
    val view: View,
    val imageView:ImageView,
    val headerText: TextView,
    val middleText:TextView,
    val button: Button
)

fun dialogHolder(view:View):DialogHolder =
    DialogHolder(
        view,
        view.findViewById(R.id.dialog_imageView),
        view.findViewById(R.id.dialog_header_textView),
        view.findViewById(R.id.dialog_textView),
        view.findViewById(R.id.dialog_button)
    )