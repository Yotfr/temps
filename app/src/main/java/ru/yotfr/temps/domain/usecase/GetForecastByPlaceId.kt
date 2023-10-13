package ru.yotfr.temps.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.PlaceWithForecast
import ru.yotfr.temps.domain.repository.PlacesRepository
import ru.yotfr.temps.domain.repository.WeatherRepository
import javax.inject.Inject

class GetForecastByPlaceId @Inject constructor(
    private val placesRepository: PlacesRepository,
    private val weatherRepository: WeatherRepository
) {

    operator fun invoke(placeId: String): Flow<DataState<PlaceWithForecast>> = flow {
        // Start loading
        emit(
            DataState.Loading()
        )

    }
}