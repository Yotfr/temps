package ru.yotfr.temps.domain.model

data class ForecastModel(
    val placeId: String,
    val current: CurrentWeather,
    val forecast: List<ForecastDay>,
    val alerts: List<Alert>
)
