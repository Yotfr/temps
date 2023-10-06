package ru.yotfr.temps.data.remote.model

data class WrappedHourlyForecastResponse(
    val list: List<HourlyWeatherResponse>
)