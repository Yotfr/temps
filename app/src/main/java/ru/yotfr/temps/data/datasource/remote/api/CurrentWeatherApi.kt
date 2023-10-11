package ru.yotfr.temps.data.datasource.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.yotfr.temps.data.datasource.remote.model.CurrentWeatherResponse

interface CurrentWeatherApi {

    @GET("current.json")
    suspend fun getCurrentWeatherByCoordinates(
        @Query("q") coordinates: String,
        @Query("aqi") airQuality: String = "yes"
    ): CurrentWeatherResponse

}