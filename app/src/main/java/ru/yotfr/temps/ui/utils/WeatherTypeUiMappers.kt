package ru.yotfr.temps.ui.utils

import ru.yotfr.temps.R
import ru.yotfr.temps.domain.model.ConditionType

fun ConditionType.animationRes(isDay: Boolean): Int = when (this) {

    ConditionType.CLEAR_SKY -> if (isDay) R.raw.clear_day else R.raw.clear_night

    ConditionType.PARTLY_CLOUDY -> if (isDay) R.raw.partly_cloudy_day
    else R.raw.partly_cloudy_night

    ConditionType.CLOUDY -> R.raw.cloudy

    ConditionType.OVERCAST -> R.raw.overcast

    ConditionType.MIST -> R.raw.mist

    ConditionType.PATCHY_LIGHT_RAIN,
    ConditionType.PATCHY_RAIN_POSSIBLE,
    ConditionType.PATCHY_FREEZING_DRIZZLE_POSSIBLE,
    ConditionType.PATCHY_LIGHT_DRIZZLE,
    ConditionType.LIGHT_RAIN_SHOWER -> if (isDay) R.raw.rain_day else R.raw.rain_night

    ConditionType.PATCHY_LIGHT_SNOW,
    ConditionType.PATCHY_SNOW_POSSIBLE,
    ConditionType.PATCHY_MODERATE_SNOW,
    ConditionType.PATCHY_HEAVY_SNOW,
    ConditionType.LIGHT_SNOW_SHOWERS -> if (isDay) R.raw.snow_day else R.raw.snow_night

    ConditionType.PATCHY_SLEET_POSSIBLE,
    ConditionType.LIGHT_SLEET_SHOWERS -> if (isDay) R.raw.sleet_day else R.raw.sleet_night

    ConditionType.THUNDERY_OUTBREAKS_POSSIBLE -> if (isDay) R.raw.thunder_day
    else R.raw.thunder_night

    ConditionType.BLOWING_SNOW,
    ConditionType.BLIZZARD -> R.raw.wind_snow

    ConditionType.FOG,
    ConditionType.FREEZING_FOG -> R.raw.fog

    ConditionType.LIGHT_DRIZZLE,
    ConditionType.FREEZING_DRIZZLE -> R.raw.drizzle

    ConditionType.HEAVY_FREEZING_DRIZZLE -> R.raw.heavy_drizzle

    ConditionType.LIGHT_RAIN,
    ConditionType.MODERATE_RAIN_AT_TIMES,
    ConditionType.LIGHT_FREEZING_RAIN -> R.raw.rain

    ConditionType.MODERATE_RAIN,
    ConditionType.HEAVY_RAIN_AT_TIMES,
    ConditionType.HEAVY_RAIN,
    ConditionType.MODERATE_OR_HEAVY_FREEZING_RAIN -> R.raw.heavy_rain

    ConditionType.LIGHT_SLEET -> R.raw.sleet

    ConditionType.MODERATE_OR_HEAVY_SLEET -> R.raw.heavy_sleet

    ConditionType.LIGHT_SNOW -> R.raw.snow

    ConditionType.MODERATE_SNOW,
    ConditionType.HEAVY_SNOW -> R.raw.heavy_snow

    ConditionType.ICE_PELLETS,
    ConditionType.LIGHT_SHOWERS_OF_ICE_PELLETS -> if (isDay) R.raw.ice_pellets_day
    else R.raw.ice_pellets_night

    ConditionType.MODERATE_OR_HEAVY_RAIN_SHOWER,
    ConditionType.TORRENTIAL_RAIN_SHOWER -> if (isDay) R.raw.rain_shower_day
    else R.raw.rain_shower_night

    ConditionType.MODERATE_OR_HEAVY_SLEET_SHOWERS -> if (isDay) R.raw.sleet_shower_day
    else R.raw.sleet_shower_night

    ConditionType.MODERATE_OR_HEAVY_SNOW_SHOWERS -> if (isDay) R.raw.snow_shower_day
    else R.raw.snow_shower_night

    ConditionType.MODERATE_OR_HEAVY_SHOWERS_OF_ICE_PELLETS -> if (isDay) R.raw.heavy_ice_pellets_day
    else R.raw.heavy_ice_pellets_night

    ConditionType.PATCHY_LIGHT_RAIN_WITH_THUNDER -> if (isDay) R.raw.thunderstorms_rain_day
    else R.raw.thunderstorms_rain_night

    ConditionType.MODERATE_OR_HEAVY_RAIN_WITH_THUNDER -> R.raw.thunderstorms_overcast_rain

    ConditionType.PATCHY_LIGHT_SNOW_WITH_THUNDER -> if (isDay) R.raw.thunderstorm_snow_day
    else R.raw.thunderstorm_snow_night

    ConditionType.MODERATE_OR_HEAVY_SNOW_WITH_THUNDER -> R.raw.thunderstorms_overcast_snow
}