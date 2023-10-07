package ru.yotfr.temps.data.remote.model

import com.google.gson.annotations.SerializedName

data class MainParametersDTO(
    @SerializedName("temp")
    val temperature: Double,
    @SerializedName("feels_like")
    val apparentTemperature: Double,
    @SerializedName("temp_min")
    val minimumTemperature: Double,
    @SerializedName("temp_max")
    val maximumTemperature: Double,
    val pressure: Int,
    val humidity: Int
)
