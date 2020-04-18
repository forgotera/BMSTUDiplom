package ru.skillbranch.places.selectScreen.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.places.R

class SelectScreenHolder(
    val view: View,
    val container:View,
    val values: RecyclerView
)

fun selectScreenHolder(view:View):SelectScreenHolder =
    SelectScreenHolder(
        view,
        view.findViewById(R.id.selectContainer),
        view.findViewById(R.id.selectValues)
    )