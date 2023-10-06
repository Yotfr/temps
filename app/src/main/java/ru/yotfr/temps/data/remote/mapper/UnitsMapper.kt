package ru.yotfr.temps.data.remote.mapper

import ru.yotfr.temps.domain.model.Units

fun Units.mapRequest(): String = this.name.lowercase()
