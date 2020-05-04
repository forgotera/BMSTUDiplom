package ru.skillbranch.places.screens.mainScreen.presentation.view

import android.view.View
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import ru.skillbranch.places.R

class MainScreenHolder(
    val view:View,
    val avatar:ImageView,
    val values: ViewPager2
)

fun mainScreenHolder(view:View):MainScreenHolder=
    MainScreenHolder(
        view,
        view.findViewById(R.id.mainScreenAvatar),
        view.findViewById(R.id.mainScreenViewPager2)
    )