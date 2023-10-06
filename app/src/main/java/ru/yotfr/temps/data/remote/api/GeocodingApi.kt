package ru.yotfr.temps.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.yotfr.temps.data.remote.model.LocationResponse
import ru.yotfr.temps.data.remote.model.WrappedHourlyForecastResponse

interface GeocodingApi {

    @GET("/direct")
    suspend fun getPlaceByName(
        @Query("q") query: String
    ): List<LocationResponse>

    @GET("/reverse")
    suspend fun getPlaceByCoordinates(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("limit") limit: Int
    ): WrappedHourlyForecastResponse

}