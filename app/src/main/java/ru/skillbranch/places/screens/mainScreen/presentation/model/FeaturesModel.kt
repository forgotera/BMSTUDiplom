package ru.skillbranch.places.screens.mainScreen.presentation.model

import com.google.gson.annotations.SerializedName

data class FeaturesModel(
    @SerializedName("type")
    val type:String,
    @SerializedName("properties")
    val properties:PlacePropertiesModel
)