package ru.yotfr.temps.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Upsert
import ru.yotfr.temps.data.datasource.local.entity.FullForecastEntity

@Dao
interface WeatherCacheDao {

    @Upsert
    suspend fun upsertForecastCache(fullForecastEntity: FullForecastEntity)


}