package ru.yotfr.temps.data.datasource.local.entity.embedded

import ru.yotfr.temps.domain.model.weather.Temperature
import ru.yotfr.temps.domain.model.weather.WeatherTypeModel
import ru.yotfr.temps.domain.model.weather.Wind

data class CurrentWeatherEmbedded(
    val weatherTypeModel: WeatherTypeModel,
    val temperature: Temperature,
    val pressure: Int,
    val humidityPercent: Int,
    val visibilityDistance: Int,
    val wind: Wind
)
