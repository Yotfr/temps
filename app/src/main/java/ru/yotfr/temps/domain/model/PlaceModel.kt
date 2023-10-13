package ru.yotfr.temps.domain.model

import java.time.LocalDateTime

data class PlaceModel(
    val id: String,
    val name: String,
    val region: String,
    val country: String,
    val coordinates: Coordinates,
    val timeZoneId: String,
    val localTimeEpoch: Int,
    val localtime: LocalDateTime,
    val isFavorite: Boolean
)
