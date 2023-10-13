package ru.yotfr.temps.data.datasource.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.yotfr.temps.data.datasource.local.entity.embedded.AlertEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.CurrentWeatherEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.ForecastEmbedded

@Entity(tableName = "forecast")
data class ForecastEntity(
    @PrimaryKey val placeId: String,
    @Embedded
    val current: CurrentWeatherEmbedded,
    val forecast: List<ForecastEmbedded>,
    val alerts: List<AlertEmbedded>
)
