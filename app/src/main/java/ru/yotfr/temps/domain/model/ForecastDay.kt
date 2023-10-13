package ru.yotfr.temps.domain.model

import java.time.LocalDate

data class ForecastDay(
    val date: LocalDate,
    val dateEpoch: Int,
    val day: Day,
    val astro: Astro,
    val hour: List<Hour>
)
