package ru.yotfr.temps.domain.model

import java.time.LocalDate

data class DailyForecast(
    val date: LocalDate,
    val hourlyForecast: List<HourlyWeather>
)
