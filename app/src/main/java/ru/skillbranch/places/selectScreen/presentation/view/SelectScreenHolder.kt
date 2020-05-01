package ru.skillbranch.places.selectScreen.presentation.view

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.R

class SelectScreenHolder(
    val view: View,
    val container:View,
    val values: RecyclerView,
    val button:Button
)

fun selectScreenHolder(view:View):SelectScreenHolder =
    SelectScreenHolder(
        view,
        view.findViewById(R.id.selectContainer),
        view.findViewById(R.id.selectValues),
        view.findViewById(R.id.selectButton)
    )