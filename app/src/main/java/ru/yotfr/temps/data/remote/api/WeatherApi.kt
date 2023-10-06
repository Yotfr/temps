package ru.yotfr.temps.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.yotfr.temps.data.remote.model.CurrentWeatherResponse

interface WeatherApi {

    @GET("/weather")
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") units: String,
        @Query("lang") language: String
    ): CurrentWeatherResponse


}