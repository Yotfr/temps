package ru.yotfr.temps.data.remote.model

import com.google.gson.annotations.SerializedName

data class CloudinessDTO(
    @SerializedName("all")
    val percent: Int
)