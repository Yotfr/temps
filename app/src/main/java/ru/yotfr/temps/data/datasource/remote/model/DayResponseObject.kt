package ru.yotfr.temps.data.datasource.remote.model

import com.google.gson.annotations.SerializedName
data class DayResponseObject(
    @SerializedName("maxtemp_c")
    val maxTempC: Double,
    @SerializedName("maxtemp_f")
    val maxTempF: Double,
    @SerializedName("mintemp_c")
    val minTempC: Double,
    @SerializedName("mintemp_f")
    val minTempF: Double,
    @SerializedName("avgtemp_c")
    val avgTempC: Double,
    @SerializedName("avgtemp_f")
    val avgTempF: Double,
    @SerializedName("maxwind_mph")
    val maxWindMph: Double,
    @SerializedName("maxwind_kph")
    val maxWindKph: Double,
    @SerializedName("totalprecip_mm")
    val totalPrecipMm: Double,
    @SerializedName("totalprecip_in")
    val totalPrecipIn: Double,
    @SerializedName("totalsnow_cm")
    val totalSnowCm: Double,
    @SerializedName("avgvis_km")
    val avgVisibilityKm: Double,
    @SerializedName("avgvis_miles")
    val avgVisibilityMiles: Double,
    @SerializedName("daily_will_it_rain")
    val dailyWillItRain: Int,
    @SerializedName("daily_chance_of_rain")
    val dailyChanceOfRain: Int,
    @SerializedName("daily_will_it_snow")
    val dailyWillItSnow: Int,
    @SerializedName("daily_chance_of_snow")
    val dailyChanceOfSnow: Int,
    val condition: ConditionResponseObject,
    val uv: Double,
    val airQuality: AirQualityResponseObject
)
