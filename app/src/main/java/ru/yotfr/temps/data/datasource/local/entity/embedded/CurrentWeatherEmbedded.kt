package ru.yotfr.temps.data.datasource.local.entity.embedded

import androidx.room.Embedded

data class CurrentWeatherEmbedded(
    val updateTimeEpoch: Int,
    val updateTime: String,
    val tempC: Double,
    val tempF: Double,
    val isDay: Int,
    @Embedded
    val condition: ConditionEmbedded,
    val windMph: Double,
    val windKph: Double,
    val windDegree: Int,
    val windDirection: String,
    val pressureMb: Double,
    val pressureIn: Double,
    val precipMm: Double,
    val precipIn: Double,
    val humidityPercent: Int,
    val cloudPercent: Int,
    val feelsLikeC: Double,
    val feelsLikeF: Double,
    val visibilityKm: Double,
    val visibilityMiles: Double,
    val uvIndex: Double,
    val gustMph: Double,
    val gustKph: Double,
    @Embedded
    val airQuality: AirQualityEmbedded
)
