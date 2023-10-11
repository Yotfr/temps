package ru.yotfr.temps.data.datasource.local.entity

import androidx.room.Entity

@Entity(
    tableName = "places",
    primaryKeys = ["latitude","longitude"]
)
data class PlaceEntity(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val state: String?
)