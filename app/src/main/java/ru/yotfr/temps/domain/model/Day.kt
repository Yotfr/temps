package ru.yotfr.temps.domain.model

data class Day(
    val maxTempC: Double,
    val maxTempF: Double,
    val minTempC: Double,
    val minTempF: Double,
    val avgTempC: Double,
    val avgTempF: Double,
    val maxWindMph: Double,
    val maxWindKph: Double,
    val totalPrecipMm: Double,
    val totalPrecipIn: Double,
    val totalSnowCm: Double,
    val avgVisibilityKm: Double,
    val avgVisibilityMiles: Double,
    val dailyWillItRain: Boolean,
    val dailyChanceOfRain: Int,
    val dailyWillItSnow: Boolean,
    val dailyChanceOfSnow: Int,
    val condition: Condition,
    val uv: Double,
    val airQuality: AirQuality
)
