package ru.yotfr.temps.domain.model.weather

data class Temperature(
    val temperature: Int,
    val apparent: Int,
    val minimum: Int,
    val maximum: Int
)