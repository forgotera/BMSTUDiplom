package ru.skillbranch.places.mainview.model

import com.google.gson.annotations.SerializedName

data class PlacesModel(
    @SerializedName("type")
    val type:String,
    @SerializedName("properties")
    val properties:PropertiesModel?,
    @SerializedName("features")
    val features:List<FeaturesModel>
)