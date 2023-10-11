package ru.yotfr.temps.data.datasource.local.entity.embedded

import androidx.room.Embedded
import java.time.LocalTime

data class HourlyWeatherEmbedded(
    @Embedded
    val weatherType: WeatherTypeEmbedded,
    @Embedded
    val temperature: TemperatureEmbedded,
    val pressure: Int,
    val humidityPercent: Int,
    val cloudinessPercent: Int,
    val visibilityDistance: Int,
    @Embedded
    val wind: WindEmbedded,
    val precipitationProbabilityPercent: Int,
    val time: LocalTime
)
