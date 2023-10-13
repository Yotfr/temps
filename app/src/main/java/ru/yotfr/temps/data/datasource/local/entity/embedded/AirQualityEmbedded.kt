package ru.yotfr.temps.data.datasource.local.entity.embedded

data class AirQualityEmbedded(
    val co: Double,
    val no2: Double,
    val o3: Double,
    val so2: Double,
    val pm2: Double,
    val pm10: Double,
    val usIndex: Int,
    val gbIndex: Int
)
