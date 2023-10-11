package ru.yotfr.temps.domain.model.weather

data class WeatherTypeModel(
    val weatherType: WeatherType,
    val weatherGroup: WeatherGroup,
    val weatherDescription: String
)
