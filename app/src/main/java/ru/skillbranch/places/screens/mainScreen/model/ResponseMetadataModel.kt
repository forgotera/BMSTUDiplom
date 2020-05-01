package ru.skillbranch.places.screens.mainScreen.model

import com.google.gson.annotations.SerializedName

data class ResponseMetadataModel(
    @SerializedName("searchRequest")
    val searchRequest:SearchRequestModel,
    @SerializedName("searchResponse")
    val searchResponse:SearchResponseModel
)