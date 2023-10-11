package ru.yotfr.temps.data.datasource.remote.model

data class ForecastResponse(
    val location: LocationResponseObject,
    val current: CurrentResponseObject,
    val forecast: ForecastResponseObject,
    val alerts: AlertsResponseObject
)
