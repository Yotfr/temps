package ru.yotfr.temps.domain.model

data class CurrentWeather(
    val weatherTypeModel: WeatherTypeModel,
    val temperature: Temperature,
    val pressure: Int,
    val humidityPercent: Int,
    val visibilityDistance: Int,
    val wind: Wind
)