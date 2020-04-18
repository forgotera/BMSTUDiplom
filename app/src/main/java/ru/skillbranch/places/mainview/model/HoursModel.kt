package ru.skillbranch.places.mainview.model

import com.google.gson.annotations.SerializedName

data class HoursModel(
    @SerializedName("availabilities")
    val availabilities:AvailabilitiesModel?,
    @SerializedName("everyday")
    val everyday:Boolean?,
    @SerializedName("twentyFourHours")
    val twentyFourHours:Boolean?,
    @SerializedName("text")
    val text:String
)