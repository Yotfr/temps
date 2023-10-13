package ru.yotfr.temps.domain.model

import java.time.LocalTime

data class Astro(
    val sunrise: LocalTime,
    val sunset: LocalTime,
    val moonrise: LocalTime,
    val moonset: LocalTime,
    val moonPhase: MoonPhase,
    val moonIlluminationPercent: Int,
    val isMoonUp: Boolean,
    val isSunUp: Boolean
)
