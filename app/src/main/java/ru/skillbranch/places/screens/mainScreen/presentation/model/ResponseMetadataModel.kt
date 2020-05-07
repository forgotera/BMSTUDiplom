package ru.skillbranch.places.screens.mainScreen.presentation.model

import com.google.gson.annotations.SerializedName

data class ResponseMetadataModel(
    @SerializedName("SearchRequest")
    val searchRequest:SearchRequestModel,
    @SerializedName("SearchResponse")
    val searchResponse:SearchResponseModel
)