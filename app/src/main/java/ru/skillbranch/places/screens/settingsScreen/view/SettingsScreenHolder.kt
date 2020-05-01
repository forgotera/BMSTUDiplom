package ru.skillbranch.places.screens.settingsScreen.view

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import ru.skillbranch.places.R

class SettingsScreenHolder(
    val view: View,
    val imageView: ImageView,
    val editText: EditText,
    val button: Button
)

fun settingsScreenHolder(view: View): SettingsScreenHolder =
    SettingsScreenHolder(
        view,
        view.findViewById(R.id.settingsScreenPhoto),
        view.findViewById(R.id.settingsScreenEditText),
        view.findViewById(R.id.settingsScreenButton)
    )
