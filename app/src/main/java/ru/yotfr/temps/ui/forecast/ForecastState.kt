package ru.yotfr.temps.ui.forecast

import ru.yotfr.temps.domain.model.PlaceWithFullForecast

data class ForecastState(
    val isLoading: Boolean = false,
    val placeWithFullForecast: PlaceWithFullForecast? = null
)
