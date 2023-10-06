package ru.yotfr.temps.data.remote.model

import com.google.gson.annotations.SerializedName

data class WindParametersDTO(
    val speed: Int,
    @SerializedName("deg")
    val directionDegrees: Int,
    val gust: Int,
)