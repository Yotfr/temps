package ru.yotfr.temps.data.datasource.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.yotfr.temps.data.datasource.remote.model.SearchResponseObject

interface SearchApi {

    @GET("search.json")
    suspend fun searchPlacesByName(
        @Query("q") name: String
    ): List<SearchResponseObject>
}