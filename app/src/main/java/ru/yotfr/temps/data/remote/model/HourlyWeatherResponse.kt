package ru.yotfr.temps.data.remote.model

import com.google.gson.annotations.SerializedName

data class HourlyWeatherResponse(
    @SerializedName("weather")
    val weatherType: WeatherTypeDTO,
    @SerializedName("main")
    val mainParameters: MainParametersDTO,
    @SerializedName("clouds")
    val cloudiness: CloudinessDTO,
    val visibility: Int,
    @SerializedName("wind")
    val windParameters: WindParametersDTO,
    @SerializedName("pop")
    val precipitationProbability: Double,
    @SerializedName("dt_txt")
    val dateTime: String
)
