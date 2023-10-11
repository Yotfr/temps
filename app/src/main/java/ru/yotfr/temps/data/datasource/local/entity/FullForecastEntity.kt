package ru.yotfr.temps.data.datasource.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import ru.yotfr.temps.data.datasource.local.entity.embedded.CurrentWeatherEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.DailyWeatherEmbedded

@Entity(tableName = "full_forecast")
data class FullForecastEntity(
    @Embedded
    val currentWeather: CurrentWeatherEmbedded,
    val dailyForecast: List<DailyWeatherEmbedded>
)
