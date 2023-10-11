package ru.yotfr.temps.data.repository

import ru.yotfr.temps.data.datasource.remote.mapper.mapToPlace
import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.place.Location
import ru.yotfr.temps.domain.model.place.Place
import ru.yotfr.temps.domain.repository.PlacesRepository
import javax.inject.Inject

class PlacesRepositoryImpl @Inject constructor(
    private val geocodingApi: GeocodingApi
) : PlacesRepository {
    override suspend fun getPlaceByLocation(
        location: Location
    ): DataState<Place> {
        return try {
            val place = geocodingApi.getPlaceByCoordinates(
                latitude = location.latitude,
                longitude = location.longitude,
                limit = 1
            ).first().mapToPlace()
            DataState.Success(
                data = place
            )
        } catch (e: Exception) {
            DataState.Error(
                message = e.message
            )
        }
    }
}