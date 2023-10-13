package ru.yotfr.temps.data.mapper

import ru.yotfr.temps.domain.model.MoonPhase

fun String.toMoonPhase(): MoonPhase {
    return MoonPhase.values().find { it.stringName == this }
        ?: throw IllegalArgumentException("Wrong moon phase")
}