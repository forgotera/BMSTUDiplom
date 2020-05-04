package ru.skillbranch.places.screens.mainScreen.presentation.model

import com.google.gson.annotations.SerializedName

data class PhonesModel(
    @SerializedName("type")
    val type:String?,
    @SerializedName("formatted")
    val formatted:String
)