package ru.yotfr.temps.data.remote.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("weather")
    val weatherType: WeatherTypeDTO,
    @SerializedName("main")
    val mainParameters: MainParametersDTO,
    val visibility: Int,
    @SerializedName("wind")
    val windParameters: WindParametersDTO,

)
