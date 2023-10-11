package ru.yotfr.temps.domain.model.place

//TODO: Local names
data class Place(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val state: String?
)
