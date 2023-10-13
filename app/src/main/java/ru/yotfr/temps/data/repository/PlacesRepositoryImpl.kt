package ru.yotfr.temps.data.repository

import ru.yotfr.temps.data.datasource.local.dao.PlacesDao
import ru.yotfr.temps.data.datasource.remote.api.PlacesApi
import ru.yotfr.temps.data.mapper.mapToCoordinates
import ru.yotfr.temps.data.mapper.mapToEntity
import ru.yotfr.temps.data.mapper.mapToPlaceModel
import ru.yotfr.temps.data.mapper.toRequest
import ru.yotfr.temps.domain.model.Coordinates
import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.PlaceModel
import ru.yotfr.temps.domain.repository.PlacesRepository
import javax.inject.Inject

class PlacesRepositoryImpl @Inject constructor(
    private val placesApi: PlacesApi,
    private val placesDao: PlacesDao
) : PlacesRepository {
    override suspend fun getCurrentLocationPlace(currentCoordinates: Coordinates?): DataState<PlaceModel> {
        // Get cached location
        val cachedLocationPlace = try {
            placesDao.getLocationPlace()
        } catch (e: Exception) {
            return DataState.Error(
                cachedData = null,
                message = e.message
            )
        }
        if (currentCoordinates == null) {
            // Coordinates not received, means error, return cached location (or null if not exisis)
            return DataState.Error(
                cachedData = cachedLocationPlace?.mapToPlaceModel(),
                message = null
            )
        }
        return try {
            if (
                cachedLocationPlace?.coordinates?.mapToCoordinates() == currentCoordinates
            ) {
                // current coordinates same as cached, return cached place
                DataState.Success(
                    data = cachedLocationPlace.mapToPlaceModel()
                )
            } else {
                // current coordinates is different or cache not exists, fetch place by coordinates
                val mappedFetchedPlace = placesApi.getPlaceByCoordinates(
                    coordinates = currentCoordinates.toRequest()
                ).mapToEntity(
                    isFavorite = false,
                    isCurrentLocation = true
                )
                // update cache
                placesDao.updateLocationPlace(
                    placeEntity = mappedFetchedPlace
                )
                // return fetched
                DataState.Success(
                    data = mappedFetchedPlace.mapToPlaceModel()
                )
            }
        } catch (e: Exception) {
            // fetch data failed, return cached data
            DataState.Error(
                cachedData = cachedLocationPlace?.mapToPlaceModel(),
                message = e.message
            )
        }
    }


}