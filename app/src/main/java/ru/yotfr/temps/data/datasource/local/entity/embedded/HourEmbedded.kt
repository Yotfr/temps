package ru.yotfr.temps.data.datasource.local.entity.embedded

import androidx.room.Embedded

data class HourEmbedded(
    val timeEpoch: Int,
    val time: String,
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
    val windChillC: Double,
    val windChillF: Double,
    val heatIndexC: Double,
    val heatIndexF: Double,
    val dewPointC: Double,
    val dewPointF: Double,
    val willItRain: Int,
    val chanceOfRain: Int,
    val willItSnow: Int,
    val chanceOfSnow: Int,
    val visibilityKm: Double,
    val visibilityMiles: Double,
    val uvIndex: Double,
    val gustMph: Double,
    val gustKph: Double,
    @Embedded
    val airQuality: AirQualityEmbedded
)
