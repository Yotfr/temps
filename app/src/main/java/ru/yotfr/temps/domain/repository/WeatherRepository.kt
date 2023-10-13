package ru.yotfr.temps.domain.repository

import ru.yotfr.temps.domain.model.DataState
import ru.yotfr.temps.domain.model.ForecastModel
import ru.yotfr.temps.domain.model.PlaceModel

interface WeatherRepository {
    suspend fun getForecastForPlace(placeModel: PlaceModel): DataState<ForecastModel>
}