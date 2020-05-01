package ru.skillbranch.places.screens.mainScreen.model

import com.google.gson.annotations.SerializedName

data class CategoriesModel(
    @SerializedName("class")
    val `class`: String?,
    @SerializedName("name")
    val name: String
)