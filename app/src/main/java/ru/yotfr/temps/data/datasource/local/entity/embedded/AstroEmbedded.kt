package ru.yotfr.temps.data.datasource.local.entity.embedded

data class AstroEmbedded(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    val moonPhase: String,
    val moonIlluminationPercent: String,
    val isMoonUp: Int,
    val isSunUp: Int
)