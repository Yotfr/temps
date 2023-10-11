package ru.yotfr.temps.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class CurrentResponseObject(
    @SerializedName("last_updated_epoch")
    val updateTimeEpoch: Int,
    @SerializedName("last_updated")
    val updateTime: String,
    @SerializedName("temp_c")
    val tempC: Double,
    @SerializedName("temp_f")
    val tempF: Double,
    @SerializedName("is_day")
    val isDay: Double,
    val condition: ConditionResponseObject,
    @SerializedName("wind_mph")
    val windMph: Double,
    @SerializedName("wind_kph")
    val windKph: Double,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDirection: String,
    @SerializedName("pressure_mb")
    val pressureMb: Double,
    @SerializedName("pressure_in")
    val pressureIn: Double,
    @SerializedName("precip_mm")
    val precipMm: Double,
    @SerializedName("precip_in")
    val precipIn: Double,
    @SerializedName("humidity")
    val humidityPercent: Int,
    @SerializedName("cloud")
    val cloudPercent: Int,
    @SerializedName("feelslike_c")
    val feelsLikeC: Double,
    @SerializedName("feelslike_f")
    val feelsLikeF: Double,
    @SerializedName("vis_km")
    val visibilityKm: Double,
    @SerializedName("vis_miles")
    val visibilityMiles: Double,
    @SerializedName("uv")
    val uvIndex: Double,
    @SerializedName("gust_mph")
    val gustMph: Double,
    @SerializedName("gust_kph")
    val gustKph: Double,
    @SerializedName("air_quality")
    val airQuality: AirQualityResponseObject
)