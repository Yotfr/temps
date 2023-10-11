package ru.yotfr.temps.ui.utils

import ru.yotfr.temps.R
import ru.yotfr.temps.domain.model.weather.Condition

fun Condition.animationRes(isDay: Boolean): Int = when (this) {

    Condition.CLEAR_SKY -> if (isDay) R.raw.clear_day else R.raw.clear_night

    Condition.PARTLY_CLOUDY -> if (isDay) R.raw.partly_cloudy_day
    else R.raw.partly_cloudy_night

    Condition.CLOUDY -> R.raw.cloudy

    Condition.OVERCAST -> R.raw.overcast

    Condition.MIST -> R.raw.mist

    Condition.PATCHY_LIGHT_RAIN,
    Condition.PATCHY_RAIN_POSSIBLE,
    Condition.PATCHY_FREEZING_DRIZZLE_POSSIBLE,
    Condition.PATCHY_LIGHT_DRIZZLE,
    Condition.LIGHT_RAIN_SHOWER -> if (isDay) R.raw.rain_day else R.raw.rain_night

    Condition.PATCHY_LIGHT_SNOW,
    Condition.PATCHY_SNOW_POSSIBLE,
    Condition.PATCHY_MODERATE_SNOW,
    Condition.PATCHY_HEAVY_SNOW,
    Condition.LIGHT_SNOW_SHOWERS -> if (isDay) R.raw.snow_day else R.raw.snow_night

    Condition.PATCHY_SLEET_POSSIBLE,
    Condition.LIGHT_SLEET_SHOWERS -> if (isDay) R.raw.sleet_day else R.raw.sleet_night

    Condition.THUNDERY_OUTBREAKS_POSSIBLE -> if (isDay) R.raw.thunder_day
    else R.raw.thunder_night

    Condition.BLOWING_SNOW,
    Condition.BLIZZARD -> R.raw.wind_snow

    Condition.FOG,
    Condition.FREEZING_FOG -> R.raw.fog

    Condition.LIGHT_DRIZZLE,
    Condition.FREEZING_DRIZZLE -> R.raw.drizzle

    Condition.HEAVY_FREEZING_DRIZZLE -> R.raw.heavy_drizzle

    Condition.LIGHT_RAIN,
    Condition.MODERATE_RAIN_AT_TIMES,
    Condition.LIGHT_FREEZING_RAIN -> R.raw.rain

    Condition.MODERATE_RAIN,
    Condition.HEAVY_RAIN_AT_TIMES,
    Condition.HEAVY_RAIN,
    Condition.MODERATE_OR_HEAVY_FREEZING_RAIN -> R.raw.heavy_rain

    Condition.LIGHT_SLEET -> R.raw.sleet

    Condition.MODERATE_OR_HEAVY_SLEET -> R.raw.heavy_sleet

    Condition.LIGHT_SNOW -> R.raw.snow

    Condition.MODERATE_SNOW,
    Condition.HEAVY_SNOW -> R.raw.heavy_snow

    Condition.ICE_PELLETS,
    Condition.LIGHT_SHOWERS_OF_ICE_PELLETS -> if (isDay) R.raw.ice_pellets_day
    else R.raw.ice_pellets_night

    Condition.MODERATE_OR_HEAVY_RAIN_SHOWER,
    Condition.TORRENTIAL_RAIN_SHOWER -> if (isDay) R.raw.rain_shower_day
    else R.raw.rain_shower_night

    Condition.MODERATE_OR_HEAVY_SLEET_SHOWERS -> if (isDay) R.raw.sleet_shower_day
    else R.raw.sleet_shower_night

    Condition.MODERATE_OR_HEAVY_SNOW_SHOWERS -> if (isDay) R.raw.snow_shower_day
    else R.raw.snow_shower_night

    Condition.MODERATE_OR_HEAVY_SHOWERS_OF_ICE_PELLETS -> if (isDay) R.raw.heavy_ice_pellets_day
    else R.raw.heavy_ice_pellets_night

    Condition.PATCHY_LIGHT_RAIN_WITH_THUNDER -> if (isDay) R.raw.thunderstorms_rain_day
    else R.raw.thunderstorms_rain_night

    Condition.MODERATE_OR_HEAVY_RAIN_WITH_THUNDER -> R.raw.thunderstorms_overcast_rain

    Condition.PATCHY_LIGHT_SNOW_WITH_THUNDER -> if (isDay) R.raw.thunderstorm_snow_day
    else R.raw.thunderstorm_snow_night

    Condition.MODERATE_OR_HEAVY_SNOW_WITH_THUNDER -> R.raw.thunderstorms_overcast_snow
}