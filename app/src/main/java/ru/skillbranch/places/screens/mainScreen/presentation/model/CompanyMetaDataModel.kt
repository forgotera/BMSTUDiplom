package ru.skillbranch.places.screens.mainScreen.presentation.model

import com.google.gson.annotations.SerializedName

data class CompanyMetaDataModel(
    @SerializedName("id")
    val id:String,
    @SerializedName("name")
    val name:String,
    @SerializedName("address")
    val address:String?,
    @SerializedName("url")
    val url:String?,
    @SerializedName("categories")
    val categories:List<CategoriesModel?>,
    @SerializedName("phones")
    val phones:List <PhonesModel?>,
    @SerializedName("hours")
    val hours:List <HoursModel?>
)