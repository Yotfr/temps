package ru.yotfr.temps.data.remote.model

import com.google.gson.annotations.SerializedName

data class WeatherTypeDTO(
    val id: Int,
    @SerializedName("name")
    val group: String,
    val description: String
)
