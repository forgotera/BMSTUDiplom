package ru.skillbranch.places.screens.mainScreen.model

import com.google.gson.annotations.SerializedName

data class PropertiesModel(
    @SerializedName("responseMetadata")
    val responseMetadata:ResponseMetadataModel
)