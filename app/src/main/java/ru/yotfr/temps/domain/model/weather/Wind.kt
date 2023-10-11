package ru.yotfr.temps.domain.model.weather

data class Wind(
    val speed: Double,
    val direction: WindDirection,
    val gust: Double
)
