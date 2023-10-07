package ru.yotfr.temps.data.remote.mapper

import ru.yotfr.temps.data.remote.model.WeatherTypeDTO
import ru.yotfr.temps.domain.model.WeatherGroup
import ru.yotfr.temps.domain.model.WeatherType
import ru.yotfr.temps.domain.model.WeatherTypeModel

fun Int.mapToWeatherType(): WeatherType = when (this) {
    200 -> WeatherType.THUNDERSTORM_LIGHT_RAIN
    201 -> WeatherType.THUNDERSTORM_RAIN
    202 -> WeatherType.THUNDERSTORM_HEAVY_RAIN
    210 -> WeatherType.LIGHT_THUNDERSTORM
    211 -> WeatherType.THUNDERSTORM
    212 -> WeatherType.HEAVY_THUNDERSTORM
    221 -> WeatherType.RAGGED_THUNDERSTORM
    230 -> WeatherType.THUNDERSTORM_LIGHT_DRIZZLE
    231 -> WeatherType.THUNDERSTORM_DRIZZLE
    232 -> WeatherType.THUNDERSTORM_HEAVY_DRIZZLE

    300 -> WeatherType.LIGHT_DRIZZLE
    301 -> WeatherType.DRIZZLE
    302 -> WeatherType.HEAVY_DRIZZLE
    310 -> WeatherType.LIGHT_DRIZZLE_RAIN
    311 -> WeatherType.DRIZZLE_RAIN
    312 -> WeatherType.HEAVY_DRIZZLE_RAIN
    313 -> WeatherType.SHOWER_RAIN_AND_DRIZZLE
    314 -> WeatherType.HEAVY_SHOWER_RAIN_AND_DRIZZLE
    321 -> WeatherType.SHOWER_DRIZZLE

    500 -> WeatherType.LIGHT_RAIN
    501 -> WeatherType.MODERATE_RAIN
    502 -> WeatherType.HEAVY_RAIN
    503 -> WeatherType.VERY_HEAVY_RAIN
    504 -> WeatherType.EXTREME_RAIN
    511 -> WeatherType.FREEZING_RAIN
    520 -> WeatherType.LIGHT_SHOWER_RAIN
    521 -> WeatherType.SHOWER_RAIN
    522 -> WeatherType.HEAVY_SHOWER_RAIN
    531 -> WeatherType.RAGGED_SHOWER_RAIN

    600 -> WeatherType.LIGHT_SNOW
    601 -> WeatherType.SNOW
    602 -> WeatherType.HEAVY_SNOW
    611 -> WeatherType.SLEET
    612 -> WeatherType.LIGHT_SHOWER_SLEET
    613 -> WeatherType.SHOWER_SLEET
    615 -> WeatherType.LIGHT_RAIN_AND_SNOW
    616 -> WeatherType.RAIN_AND_SNOW
    620 -> WeatherType.LIGHT_SHOWER_SNOW
    621 -> WeatherType.SHOWER_SNOW
    622 -> WeatherType.HEAVY_SHOWER_SNOW

    701 -> WeatherType.MIST
    711 -> WeatherType.SMOKE
    721 -> WeatherType.HAZE
    731 -> WeatherType.SAND_OR_DUST_WHIRLS
    741 -> WeatherType.FOG
    751 -> WeatherType.SAND
    761 -> WeatherType.DUST
    762 -> WeatherType.VOLCANIC_ASH
    771 -> WeatherType.SQUALLS
    781 -> WeatherType.TORNADO

    800 -> WeatherType.CLEAR_SKY

    801 -> WeatherType.FEW_CLOUDS
    802 -> WeatherType.SCATTERED_CLOUDS
    803 -> WeatherType.BROKEN_CLOUDS
    804 -> WeatherType.OVERCAST_CLOUDS

    else -> throw IllegalArgumentException(
        "Wrong weather code"
    )
}

fun String.mapToWeatherGroup(): WeatherGroup = when (this) {
    "Thunderstorm" -> WeatherGroup.THUNDERSTORM
    "Drizzle" -> WeatherGroup.DRIZZLE
    "Rain" -> WeatherGroup.RAIN
    "Snow" -> WeatherGroup.SNOW
    "Mist" -> WeatherGroup.MIST
    "Smoke" -> WeatherGroup.SMOKE
    "Haze" -> WeatherGroup.HAZE
    "Dust" -> WeatherGroup.DUST
    "Fog" -> WeatherGroup.FOG
    "Sand" -> WeatherGroup.SAND
    "Ash" -> WeatherGroup.ASH
    "Squall" -> WeatherGroup.SQUALL
    "Tornado" -> WeatherGroup.TORNADO
    "Clear" -> WeatherGroup.CLEAR
    "Clouds" -> WeatherGroup.CLOUDS

    else -> throw IllegalArgumentException(
        "Wrong weather group"
    )
}

fun WeatherTypeDTO.mpToWeatherTypeModel(): WeatherTypeModel =
    WeatherTypeModel(
        weatherType = id.mapToWeatherType(),
        weatherGroup = group.mapToWeatherGroup(),
        weatherDescription = description
    )