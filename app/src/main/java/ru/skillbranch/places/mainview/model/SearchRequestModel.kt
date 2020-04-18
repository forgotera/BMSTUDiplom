package ru.skillbranch.places.mainview.model

import com.google.gson.annotations.SerializedName

data class SearchRequestModel(
    @SerializedName("request")
    val request:String,
    @SerializedName("result")
    val result:Int?,
    @SerializedName("skip")
    val skip:Int?
)