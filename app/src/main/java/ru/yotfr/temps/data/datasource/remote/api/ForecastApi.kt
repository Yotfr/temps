package ru.yotfr.temps.data.datasource.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.yotfr.temps.data.datasource.remote.model.ForecastResponse

interface ForecastApi {

    @GET("forecast.json")
    suspend fun getForecastByCoordinates(
        @Query("q") coordinates: String,
        @Query("aqi") airQuality: String = "yes",
        @Query("days") days: Int = 10,
        @Query("alerts") alerts: String = "yes"
    ): ForecastResponse
}