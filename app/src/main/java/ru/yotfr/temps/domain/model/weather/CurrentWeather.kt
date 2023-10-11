package ru.yotfr.temps.domain.model.weather

import androidx.room.Embedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.TemperatureEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.WeatherTypeEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.WindEmbedded
import java.time.LocalTime

data class CurrentWeather(
    @Embedded
    val weatherType: WeatherTypeEmbedded,
    @Embedded
    val temperature: TemperatureEmbedded,
    val pressure: Int,
    val humidityPercent: Int,
    val visibilityDistance: Int,
    @Embedded
    val wind: WindEmbedded,
    val time: LocalTime
)