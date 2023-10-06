package ru.yotfr.temps.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.yotfr.temps.data.remote.model.CurrentWeatherResponse
import ru.yotfr.temps.data.remote.model.WrappedHourlyForecastResponse

interface WeatherApi {

    @GET("/weather")
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") units: String,
        @Query("lang") language: String
    ): CurrentWeatherResponse

    @GET("/forecast")
    suspend fun getHourlyForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") units: String,
        @Query("lang") language: String
    ): WrappedHourlyForecastResponse


}