package ru.yotfr.temps.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class ForecastDayResponseObject(
    val date: String,
    @SerializedName("date_epoch")
    val dateEpoch: Int,
    val day: DayResponseObject,
    val astro: AstroResponseObject,
    val hour: List<HourResponseObject>
)
