package ru.skillbranch.places.mainview.model

import com.google.gson.annotations.SerializedName

data class SearchResponseModel(
    @SerializedName("found")
    val found:Int
)