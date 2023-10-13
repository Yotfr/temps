package ru.yotfr.temps.domain.location

import ru.yotfr.temps.domain.model.Coordinates

interface LocationProvider {
    suspend fun getCurrentCoordinates(): Coordinates?
}