package ru.yotfr.temps.domain.repository

import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.place.Location
import ru.yotfr.temps.domain.model.place.Place

interface PlacesRepository {
    suspend fun getPlaceByLocation(
        location: Location
    ) : DataState<Place>
}