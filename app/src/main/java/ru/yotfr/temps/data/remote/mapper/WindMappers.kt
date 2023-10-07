package ru.yotfr.temps.data.remote.mapper

import ru.yotfr.temps.data.remote.model.WindParametersDTO
import ru.yotfr.temps.domain.model.Wind
import ru.yotfr.temps.domain.model.WindDirection

fun Int.mapToWindDirection(): WindDirection = when(this) {
    in 349..360,
        in 0..11 -> WindDirection.N
    in 12..33 -> WindDirection.NNE
    in 34..56 -> WindDirection.NE
    in 57..78 -> WindDirection.ENE
    in 79..101 -> WindDirection.E
    in 102..123 -> WindDirection.ESE
    in 124..146 -> WindDirection.SE
    in 147..168 -> WindDirection.SSE
    in 169..191 -> WindDirection.S
    in 192..213 -> WindDirection.SSW
    in 214..236 -> WindDirection.SW
    in 237..258 -> WindDirection.WSW
    in 259..281 -> WindDirection.W
    in 282..303 -> WindDirection.WNW
    in 304..326 -> WindDirection.NW
    in 327..348 -> WindDirection.NNW

    else -> throw IllegalArgumentException(
        "Wrong wind direction degree"
    )
}

fun WindParametersDTO.mapToWind(): Wind =
    Wind(
        speed = speed,
        direction = directionDegrees.mapToWindDirection(),
        gust = gust
    )