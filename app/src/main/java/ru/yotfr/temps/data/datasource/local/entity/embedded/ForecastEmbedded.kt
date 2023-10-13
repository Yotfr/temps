package ru.yotfr.temps.data.datasource.local.entity.embedded

import androidx.room.Embedded

data class ForecastEmbedded(
    val date: String,
    val dateEpoch: Int,
    @Embedded
    val day: DayEmbedded,
    @Embedded
    val astro: AstroEmbedded,
    val hour: List<HourEmbedded>
)
