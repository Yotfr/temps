package ru.yotfr.temps.data.repository

import ru.yotfr.temps.data.datasource.remote.api.CurrentWeatherApi
import ru.yotfr.temps.data.datasource.remote.mapper.mapRequest
import ru.yotfr.temps.data.datasource.remote.mapper.mapToCurrentWeather
import ru.yotfr.temps.data.datasource.remote.mapper.mapToDailyForecast
import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.weather.FullForecast
import ru.yotfr.temps.domain.model.place.Place
import ru.yotfr.temps.domain.model.Units
import ru.yotfr.temps.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: CurrentWeatherApi
) : WeatherRepository {
    override suspend fun getFullForecastForPlace(place: Place): DataState<FullForecast> {
        try {
            val currentForecast = weatherApi.getCurrentWeather(
                latitude = place.latitude,
                longitude = place.longitude,
                units = Units.METRIC.mapRequest(),
                language = "en"
            ).mapToCurrentWeather()
            val dailyForecast = weatherApi.getHourlyForecast(
                latitude = place.latitude,
                longitude = place.longitude,
                units = Units.METRIC.mapRequest(),
                language = "en"
            ).mapToDailyForecast()
            val fullForecast = FullForecast(
                currentWeather = currentForecast,
                dailyForecast = dailyForecast
            )
            return DataState.Success(
                data = fullForecast
            )
        } catch (e: Exception) {
            return DataState.Error(
                message = e.message
            )
        }
    }
}