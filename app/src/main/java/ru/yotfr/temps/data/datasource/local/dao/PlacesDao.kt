package ru.yotfr.temps.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import ru.yotfr.temps.data.datasource.local.entity.PlaceEntity

@Dao
interface PlacesDao {
    @Insert
    suspend fun insertPlace(placeEntity: PlaceEntity)
    @Delete
    suspend fun deletePlace(placeEntity: PlaceEntity)

    @Query("SELECT * FROM places WHERE id = :placeId")
    suspend fun getPlaceByPlaceId(placeId: String): PlaceEntity?

    @Query("SELECT * FROM places WHERE isCurrentLocation = 1")
    suspend fun getLocationPlace(): PlaceEntity?

    @Query("DELETE FROM places WHERE isCurrentLocation = 1")
    suspend fun deleteLocationPlace()

    @Transaction
    suspend fun updateLocationPlace(placeEntity: PlaceEntity) {
        deleteLocationPlace()
        insertPlace(placeEntity = placeEntity)
    }
}