package ru.yotfr.temps.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import ru.yotfr.temps.data.datasource.local.entity.ForecastEntity

@Dao
interface ForecastDao {
    @Upsert
    suspend fun upsertForecast(forecastEntity: ForecastEntity)

    @Query("SELECT * FROM forecast WHERE placeId = :placeId")
    suspend fun getForecastByPlaceId(placeId: String): ForecastEntity?

}