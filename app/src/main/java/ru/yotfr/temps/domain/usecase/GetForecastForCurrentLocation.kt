package ru.yotfr.temps.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.yotfr.temps.domain.location.LocationProvider
import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.PlaceModel
import ru.yotfr.temps.domain.model.PlaceWithForecast
import ru.yotfr.temps.domain.repository.PlacesRepository
import ru.yotfr.temps.domain.repository.WeatherRepository
import javax.inject.Inject

class GetForecastForCurrentLocation @Inject constructor(
    private val placesRepository: PlacesRepository,
    private val weatherRepository: WeatherRepository,
    private val locationProvider: LocationProvider
) {
    operator fun invoke(): Flow<DataState<PlaceWithForecast>> = flow {
        // Start loading
        emit(
            DataState.Loading()
        )
        // Get coordinates
        val currentCoordinates = locationProvider.getCurrentCoordinates()
        // Get place for current location
        val currentLocationPlaceResponse = placesRepository.getCurrentLocationPlace(
            currentCoordinates = currentCoordinates
        )
        when(currentLocationPlaceResponse) {
            is DataState.Loading -> {
                emit(
                    DataState.Loading()
                )
            }
            is DataState.Success -> {
                // Place successfully received
                emit(
                    getForecastForPlace(
                        placeModel = currentLocationPlaceResponse.data
                    )
                )
            }
            is DataState.Error -> {
                // Error getting place
                if (currentLocationPlaceResponse.cachedData != null) {
                    // Received cached place data
                    emit(
                        getForecastForPlace(
                            placeModel = currentLocationPlaceResponse.cachedData
                        )
                    )
                } else {
                    // Cached place not exists
                    emit(
                        DataState.Error(
                            cachedData = null,
                            message = currentLocationPlaceResponse.message
                        )
                    )
                }
            }
        }
    }


    private suspend fun getForecastForPlace(placeModel: PlaceModel): DataState<PlaceWithForecast> {
        val response = weatherRepository.getForecastForPlace(
            placeModel = placeModel
        )
        return when(response) {
            is DataState.Error -> {
                // Weather received with error
                response.cachedData?.let { forecastModelCache ->
                    // Received weather cache, return error state with cache
                    DataState.Error(
                        cachedData = PlaceWithForecast(
                            place = placeModel,
                            forecast = forecastModelCache
                        ),
                        message = response.message
                    )
                } ?: kotlin.run {
                    // Weather cache not exists, return error state
                    DataState.Error(
                        cachedData = null,
                        message = response.message
                    )
                }
            }
            is DataState.Loading -> {
                DataState.Loading()
            }
            is DataState.Success -> {
                // Weather successfully received, return success state
               DataState.Success(
                    data = PlaceWithForecast(
                        place = placeModel,
                        forecast = response.data
                    )
                )
            }
        }
    }
}