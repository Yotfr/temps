package ru.yotfr.temps.data.mapper

import ru.yotfr.temps.data.datasource.local.entity.PlaceEntity
import ru.yotfr.temps.data.datasource.local.entity.embedded.CoordinatesEmbedded
import ru.yotfr.temps.data.datasource.remote.model.LocationResponseObject
import ru.yotfr.temps.domain.model.Coordinates
import ru.yotfr.temps.domain.model.PlaceModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocationResponseObject.mapToEntity(
    isFavorite: Boolean,
    isCurrentLocation: Boolean
): PlaceEntity =
    PlaceEntity(
        id = "$lat$lon",
        name = name,
        region = region,
        country = country,
        coordinates = CoordinatesEmbedded(
            latitude = lat,
            longitude = lon
        ),
        timeZoneId = timeZoneId,
        localTimeEpoch = localTimeEpoch,
        localtime = localtime,
        isFavorite = isFavorite,
        isCurrentLocation = isCurrentLocation
    )

fun PlaceEntity.mapToPlaceModel(): PlaceModel =
    PlaceModel(
        id = id,
        name = name,
        region = region,
        country = country,
        coordinates = coordinates.mapToCoordinates(),
        timeZoneId = timeZoneId,
        localTimeEpoch = localTimeEpoch,
        localtime = LocalDateTime.parse(
            localtime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        ),
        isFavorite = isFavorite
    )

fun CoordinatesEmbedded.mapToCoordinates(): Coordinates {
    return Coordinates(
        latitude = latitude,
        longitude = longitude
    )
}

