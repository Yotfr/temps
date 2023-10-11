package ru.yotfr.temps.domain.model

import ru.yotfr.temps.domain.model.place.Place

data class PlaceWithFullForecast(
    val place: Place,
    val forecast: FullForecast
)
