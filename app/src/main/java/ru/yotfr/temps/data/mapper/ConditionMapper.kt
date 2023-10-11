package ru.yotfr.temps.data.mapper

import ru.yotfr.temps.domain.model.weather.Condition

fun Int.toCondition(): Condition {
    return Condition.values().find { it.code == this }
        ?: throw IllegalArgumentException("Wrong condition code")
}