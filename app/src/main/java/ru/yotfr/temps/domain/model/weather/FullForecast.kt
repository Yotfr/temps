package ru.yotfr.temps.domain.model.weather

data class FullForecast(
    val currentWeather: CurrentWeather,
    val dailyForecast: List<DailyWeather>
)
