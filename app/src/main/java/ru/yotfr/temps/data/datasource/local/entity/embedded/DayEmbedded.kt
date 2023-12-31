package ru.yotfr.temps.data.datasource.local.entity.embedded

import androidx.room.Embedded

data class DayEmbedded(
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
    val dailyWillItRain: Int,
    val dailyChanceOfRain: Int,
    val dailyWillItSnow: Int,
    val dailyChanceOfSnow: Int,
    @Embedded
    val condition: ConditionEmbedded,
    val uv: Double,
    @Embedded
    val airQuality: AirQualityEmbedded
)