package ru.yotfr.temps.domain.model

import ru.yotfr.temps.domain.model.place.Place
import ru.yotfr.temps.domain.model.weather.FullForecast

data class PlaceWithFullForecast(
    val place: Place,
    val forecast: FullForecast
)
