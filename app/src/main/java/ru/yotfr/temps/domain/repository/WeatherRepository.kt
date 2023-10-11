package ru.yotfr.temps.domain.repository

import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.weather.FullForecast
import ru.yotfr.temps.domain.model.place.Place

interface WeatherRepository {
    suspend fun getFullForecastForPlace(place: Place): DataState<FullForecast>
}