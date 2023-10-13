package ru.yotfr.temps.data.datasource.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.yotfr.temps.data.datasource.remote.model.LocationResponseObject

interface PlacesApi {

    @GET("timezone.json")
    suspend fun getPlaceByCoordinates(
        @Query("q") coordinates: String
    ): LocationResponseObject
}