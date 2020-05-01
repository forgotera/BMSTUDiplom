package ru.skillbranch.places.screens.mainScreen.model

import com.google.gson.annotations.SerializedName

data class SearchResponseModel(
    @SerializedName("found")
    val found:Int
)