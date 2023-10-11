package ru.yotfr.temps.data.datasource.local.entity.embedded

data class CurrentWeatherEmbedded(
    val weatherTypeModel: WeatherTypeModel,
    val temperature: Temperature,
    val pressure: Int,
    val humidityPercent: Int,
    val visibilityDistance: Int,
    val wind: Wind
)
