package ru.yotfr.temps.data.mapper

import ru.yotfr.temps.domain.model.Coordinates

fun Coordinates.toRequest(): String {
    return "${this.latitude},${this.longitude}"
}

fun Coordinates.toPlaceId(): String {
    return "$latitude,$longitude"
}