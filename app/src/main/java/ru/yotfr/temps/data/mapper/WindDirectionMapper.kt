package ru.yotfr.temps.data.mapper

import ru.yotfr.temps.domain.model.WindDirection

fun String.toWindDirection(): WindDirection {
    return WindDirection.valueOf(this)
}