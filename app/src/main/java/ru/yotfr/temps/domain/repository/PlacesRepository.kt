package ru.yotfr.temps.domain.repository

import ru.yotfr.temps.domain.model.Coordinates
import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.PlaceModel

interface PlacesRepository {
    suspend fun getCurrentLocationPlace(
        currentCoordinates: Coordinates?
    ): DataState<PlaceModel>


}