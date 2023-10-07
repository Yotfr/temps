package ru.yotfr.temps.ui.utils

import ru.yotfr.temps.R
import ru.yotfr.temps.domain.model.WeatherType

fun WeatherType.animationRes(isDay: Boolean): Int = when (this) {

    WeatherType.THUNDERSTORM_LIGHT_RAIN,
    WeatherType.THUNDERSTORM_LIGHT_DRIZZLE -> R.raw.thunderstorms_rain

    WeatherType.THUNDERSTORM_RAIN,
    WeatherType.THUNDERSTORM_DRIZZLE -> R.raw.thunderstorms_overcast_rain

    WeatherType.THUNDERSTORM_HEAVY_RAIN,
    WeatherType.THUNDERSTORM_HEAVY_DRIZZLE -> R.raw.thunderstorms_extreme_rain

    WeatherType.LIGHT_THUNDERSTORM -> R.raw.thunderstorms
    WeatherType.THUNDERSTORM -> R.raw.thunderstorms_overcast
    WeatherType.HEAVY_THUNDERSTORM -> R.raw.thunderstorms_extreme
    WeatherType.RAGGED_THUNDERSTORM -> R.raw.thunderstorms_extreme

    WeatherType.LIGHT_DRIZZLE,
    WeatherType.LIGHT_DRIZZLE_RAIN -> R.raw.drizzle

    WeatherType.DRIZZLE,
    WeatherType.DRIZZLE_RAIN,
    WeatherType.SHOWER_RAIN_AND_DRIZZLE,
    WeatherType.SHOWER_DRIZZLE -> R.raw.overcast_drizzle

    WeatherType.HEAVY_DRIZZLE,
    WeatherType.HEAVY_DRIZZLE_RAIN,
    WeatherType.HEAVY_SHOWER_RAIN_AND_DRIZZLE -> R.raw.extreme_drizzle

    WeatherType.LIGHT_RAIN,
    WeatherType.LIGHT_SHOWER_RAIN -> R.raw.rain

    WeatherType.MODERATE_RAIN,
    WeatherType.SHOWER_RAIN -> R.raw.overcast_rain

    WeatherType.HEAVY_RAIN,
    WeatherType.VERY_HEAVY_RAIN,
    WeatherType.EXTREME_RAIN,
    WeatherType.HEAVY_SHOWER_RAIN,
    WeatherType.RAGGED_SHOWER_RAIN -> R.raw.extreme_rain

    WeatherType.FREEZING_RAIN,
    WeatherType.SLEET,
    WeatherType.LIGHT_SHOWER_SLEET,
    WeatherType.LIGHT_RAIN_AND_SNOW -> R.raw.sleet

    WeatherType.LIGHT_SNOW,
    WeatherType.LIGHT_SHOWER_SNOW -> R.raw.snow

    WeatherType.SNOW,
    WeatherType.SHOWER_SNOW -> R.raw.overcast_snow

    WeatherType.HEAVY_SNOW,
    WeatherType.HEAVY_SHOWER_SNOW -> R.raw.extreme_snow

    WeatherType.SHOWER_SLEET,
    WeatherType.RAIN_AND_SNOW -> R.raw.overcast_sleet

    WeatherType.MIST -> R.raw.mist
    WeatherType.SMOKE -> R.raw.smoke
    WeatherType.HAZE -> R.raw.haze
    WeatherType.SAND_OR_DUST_WHIRLS -> R.raw.dust_wind
    WeatherType.FOG -> R.raw.fog
    WeatherType.SAND -> R.raw.dust
    WeatherType.DUST -> R.raw.dust
    WeatherType.VOLCANIC_ASH -> R.raw.smoke

    WeatherType.SQUALLS,
    WeatherType.TORNADO -> R.raw.tornado

    WeatherType.CLEAR_SKY -> {
        if (isDay) R.raw.clear_day else R.raw.clear_night
    }

    WeatherType.FEW_CLOUDS -> {
        if (isDay) R.raw.clear_day else R.raw.clear_night
    }

    WeatherType.SCATTERED_CLOUDS -> {
        if (isDay) R.raw.partly_cloudy_day else R.raw.partly_cloudy_night
    }

    WeatherType.BROKEN_CLOUDS -> {
        if (isDay) R.raw.overcast_day else R.raw.overcast_night
    }

    WeatherType.OVERCAST_CLOUDS -> R.raw.overcast
}