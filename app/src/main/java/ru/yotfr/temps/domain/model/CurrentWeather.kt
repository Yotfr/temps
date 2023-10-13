package ru.yotfr.temps.domain.model

import java.time.LocalDateTime
data class CurrentWeather(
    val updateTimeEpoch: Int,
    val updateTime: LocalDateTime,
    val tempC: Double,
    val tempF: Double,
    val isDay: Boolean,
    val condition: Condition,
    val windMph: Double,
    val windKph: Double,
    val windDegree: Int,
    val windDirection: WindDirection,
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
    val airQuality: AirQuality
)
