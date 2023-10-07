package ru.yotfr.temps.domain.model

data class Wind(
    val speed: Double,
    val direction: WindDirection,
    val gust: Double
)
