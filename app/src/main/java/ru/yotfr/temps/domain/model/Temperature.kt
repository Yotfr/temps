package ru.yotfr.temps.domain.model

data class Temperature(
    val temperature: Double,
    val apparent: Double,
    val minimum: Double,
    val maximum: Double
)