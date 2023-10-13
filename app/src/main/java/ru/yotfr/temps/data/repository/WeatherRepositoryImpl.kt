package ru.yotfr.temps.data.repository

import ru.yotfr.temps.data.datasource.local.dao.ForecastDao
import ru.yotfr.temps.data.datasource.remote.api.ForecastApi
import ru.yotfr.temps.data.mapper.mapToEntity
import ru.yotfr.temps.data.mapper.mapToForecastModel
import ru.yotfr.temps.data.mapper.toRequest
import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.ForecastModel
import ru.yotfr.temps.domain.model.PlaceModel
import ru.yotfr.temps.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val forecastApi: ForecastApi,
    private val forecastDao: ForecastDao
) : WeatherRepository {
    override suspend fun getForecastForPlace(placeModel: PlaceModel): DataState<ForecastModel> {
        // Get cached forecast
        val cachedForecast = try {
            forecastDao.getForecastByPlaceId(
                placeId = placeModel.id
            )
        } catch (e: Exception) {
            return DataState.Error(
                cachedData = null,
                message = e.message
            )
        }
        return try {
            // Fetch forecast
            val mappedFetchForecast = forecastApi.getForecastByCoordinates(
                coordinates = placeModel.coordinates.toRequest()
            ).mapToEntity(
                placeId = placeModel.id
            )
            if (mappedFetchForecast == cachedForecast) {
                // cached data exists and fetched data the same as cached, return cached
                DataState.Success(
                    data = cachedForecast.mapToForecastModel()
                )
            } else {
                // fetched data is different, update cache
                forecastDao.upsertForecast(
                    forecastEntity = mappedFetchForecast
                )
                // return fetched
                DataState.Success(
                    data = mappedFetchForecast.mapToForecastModel()
                )
            }
        } catch (e: Exception) {
            // fetch data failed, return cached data
            DataState.Error(
                cachedData = cachedForecast?.mapToForecastModel(),
                message = e.message
            )
        }
    }
}