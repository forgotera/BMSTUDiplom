package ru.skillbranch.places.screens.mainScreen.presentation.model

import com.google.gson.annotations.SerializedName

data class PlacePropertiesModel(
    @SerializedName("CompanyMetaData")
    val companyMetaData: CompanyMetaDataModel?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("name")
    val name:String?
)