package ru.yotfr.temps.data.datasource.local.entity.embedded

data class TemperatureEmbedded(
    val temperature: Int,
    val apparent: Int,
    val minimum: Int,
    val maximum: Int
)
