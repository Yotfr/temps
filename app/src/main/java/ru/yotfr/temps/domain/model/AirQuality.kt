package ru.yotfr.temps.domain.model

data class AirQuality(
    val co: Double,
    val no2: Double,
    val o3: Double,
    val so2: Double,
    val pm2: Double,
    val pm10: Double,
    val usIndex: Int,
    val gbIndex: Int
)
