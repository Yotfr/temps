package ru.yotfr.temps.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class AirQualityResponseObject(
    val co: Double,
    val no2: Double,
    val o3: Double,
    val so2: Double,
    @SerializedName("pm2_5")
    val pm2: Double,
    val pm10: Double,
    @SerializedName("us-epa-index")
    val usIndex: Int,
    @SerializedName("gb-defra-index")
    val gbIndex: Int
)