package ru.yotfr.temps.data.remote.model

import com.google.gson.annotations.SerializedName

data class LocationResponse(
    val name: String,
    @SerializedName("local_names")
    val localNames: Map<String, String>,
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lon")
    val longitude: Double,
    val country: String,
    val state: String?
)
