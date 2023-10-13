package ru.yotfr.temps.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.yotfr.temps.data.datasource.local.converter.TempsTypeConverters
import ru.yotfr.temps.data.datasource.local.entity.ForecastEntity
import ru.yotfr.temps.data.datasource.local.entity.PlaceEntity

@Database(
    entities = [
        ForecastEntity::class,
        PlaceEntity::class
    ],
    version = 1
)
@TypeConverters(TempsTypeConverters::class)
abstract class TempsDatabase : RoomDatabase() {
    abstract fun weatherCacheDao(): ForecastDao
}