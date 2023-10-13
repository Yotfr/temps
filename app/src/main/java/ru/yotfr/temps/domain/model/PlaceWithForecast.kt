package ru.yotfr.temps.domain.model

data class PlaceWithForecast(
    val place: PlaceModel,
    val forecast: ForecastModel
)
