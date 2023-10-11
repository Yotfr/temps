package ru.yotfr.temps.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class LocationResponseObject(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    @SerializedName("tz_id")
    val timeZoneId: String,
    @SerializedName("localtime_epoch")
    val localTimeEpoch: Int,
    val localtime: String
)