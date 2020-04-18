package ru.skillbranch.places.mainview.model

import com.google.gson.annotations.SerializedName

data class PropertiesModel(
    @SerializedName("responseMetadata")
    val responseMetadata:ResponseMetadataModel
)