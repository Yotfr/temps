package ru.yotfr.temps.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.yotfr.temps.domain.location.LocationProvider
import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.PlaceWithFullForecast
import ru.yotfr.temps.domain.model.onError
import ru.yotfr.temps.domain.model.onSuccess
import ru.yotfr.temps.domain.repository.PlacesRepository
import ru.yotfr.temps.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val locationProvider: LocationProvider,
    private val weatherRepository: WeatherRepository,
    private val placesRepository: PlacesRepository
) {
    operator fun invoke(): Flow<DataState<PlaceWithFullForecast>> = flow {
        emit(DataState.Loading())
        locationProvider.getCurrentLocation().onError locationOnError@ {
            emit(DataState.Error(it))
            return@locationOnError
        }.onSuccess locationOnSuccess@ { location ->
            placesRepository.getPlaceByLocation(
                location = location
            ).onError placeOnError@ {
                emit(DataState.Error(it))
                return@placeOnError
            }.onSuccess placeOnSuccess@ { place ->
                weatherRepository.getFullForecastForPlace(
                    place = place
                ).onError weatherOnError@ {
                    emit(DataState.Error(it))
                    return@weatherOnError
                }.onSuccess weatherOnSuccess@ { fullForecast ->
                    emit(
                        DataState.Success(
                            data = PlaceWithFullForecast(
                                place = place,
                                forecast = fullForecast
                            )
                        )
                    )
                }
            }
        }
    }.flowOn(Dispatchers.IO)
}