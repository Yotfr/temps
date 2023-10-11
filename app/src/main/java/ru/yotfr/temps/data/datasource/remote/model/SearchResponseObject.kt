package ru.yotfr.temps.data.datasource.remote.model

data class SearchResponseObject(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double
)
