package ru.yotfr.temps.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.yotfr.temps.data.datasource.local.entity.embedded.CoordinatesEmbedded

@Entity(tableName = "places")
data class PlaceEntity(
    @PrimaryKey val id: String,
    val name: String,
    val region: String,
    val country: String,
    val coordinates: CoordinatesEmbedded,
    val timeZoneId: String,
    val localTimeEpoch: Int,
    val localtime: String,
    val isFavorite: Boolean,
    val isCurrentLocation: Boolean
)
