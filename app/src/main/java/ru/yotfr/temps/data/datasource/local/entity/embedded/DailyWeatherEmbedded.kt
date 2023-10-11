package ru.yotfr.temps.data.datasource.local.entity.embedded

import java.time.LocalDate

data class DailyWeatherEmbedded(
    val date: LocalDate,
    val hourlyForecast: List<HourlyWeatherEmbedded>
)
