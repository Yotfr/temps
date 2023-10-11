package ru.yotfr.temps.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.yotfr.temps.data.datasource.local.dao.WeatherCacheDao
import ru.yotfr.temps.data.datasource.local.entity.FullForecastEntity

@Database(
    entities = [
        FullForecastEntity::class
    ],
    version = 1
)
abstract class TempsDatabase : RoomDatabase() {
    abstract fun weatherCacheDao(): WeatherCacheDao
}