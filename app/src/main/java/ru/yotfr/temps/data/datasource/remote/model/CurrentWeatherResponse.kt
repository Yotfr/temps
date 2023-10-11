package ru.yotfr.temps.data.datasource.remote.model

data class CurrentWeatherResponse(
    val location: LocationResponseObject,
    val current: CurrentResponseObject
)
