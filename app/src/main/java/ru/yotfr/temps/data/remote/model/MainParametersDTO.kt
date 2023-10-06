package ru.yotfr.temps.data.remote.model

import com.google.gson.annotations.SerializedName

data class MainParametersDTO(
    @SerializedName("temp")
    val temperature: Int,
    @SerializedName("feels_like")
    val apparentTemperature: Int,
    @SerializedName("temp_min")
    val minimumTemperature: Int,
    @SerializedName("temp_max")
    val maximumTemperature: Int,
    val pressure: Int,
    val humidity: Int
)
