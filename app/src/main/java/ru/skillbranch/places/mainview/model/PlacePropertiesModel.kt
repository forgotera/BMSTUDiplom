package ru.skillbranch.places.mainview.model

import com.google.gson.annotations.SerializedName

data class PlacePropertiesModel(
    @SerializedName("companyMetaData")
    val companyMetaData: CompanyMetaDataModel?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("name")
    val name:String?
)