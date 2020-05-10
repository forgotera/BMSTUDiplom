package ru.skillbranch.places.screens.mainScreen.presentation.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import ru.skillbranch.places.R

class MainScreenHolder(
    val view:View,
    val toolbar:Toolbar,
    val avatar:ImageView,
    val textHello:TextView,
    val values: ViewPager2
)

fun mainScreenHolder(view:View):MainScreenHolder=
    MainScreenHolder(
        view,
        view.findViewById(R.id.toolbar),
        view.findViewById(R.id.mainScreenAvatar),
        view.findViewById(R.id.mainScreenHello),
        view.findViewById(R.id.mainScreenViewPager2)
    )