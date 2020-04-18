package ru.skillbranch.places.mainview.model

import com.google.gson.annotations.SerializedName

//todo очень странный класс/проверить!
data class AvailabilitiesModel (
    @SerializedName("Weekdays")
    val weekdays:Boolean?,
    @SerializedName("Weekend")
    val weekend:Boolean?,
    @SerializedName("Everyday")
    val everyday:Boolean?,
    @SerializedName("Sunday")
    val sunday:Boolean?,
    @SerializedName("Monday")
    val monday: Boolean?,
    @SerializedName("TwentyFourHours")
    val twentyFourHours:Boolean?,
    @SerializedName("Intervals")
    val intervals:String?
)