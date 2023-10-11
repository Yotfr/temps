package ru.yotfr.temps.domain.location

import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.place.Location

interface LocationProvider {
    suspend fun getCurrentLocation(): DataState<Location>
}