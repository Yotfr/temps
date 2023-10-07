package ru.yotfr.temps.domain.model

import java.time.LocalTime

data class HourlyWeather(
    val weatherTypeModel: WeatherTypeModel,
    val temperature: Temperature,
    val pressure: Int,
    val humidityPercent: Int,
    val cloudinessPercent: Int,
    val visibilityDistance: Int,
    val wind: Wind,
    val precipitationProbabilityPercent: Int,
    val time: LocalTime
)
