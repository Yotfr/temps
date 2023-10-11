package ru.yotfr.temps.domain.model.weather

import java.time.LocalDate

data class DailyWeather(
    val date: LocalDate,
    val hourlyForecast: List<HourlyWeather>
)
