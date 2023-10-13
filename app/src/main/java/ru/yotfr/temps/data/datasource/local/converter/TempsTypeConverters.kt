package ru.yotfr.temps.data.datasource.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.yotfr.temps.data.datasource.local.entity.embedded.AlertEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.ForecastEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.HourEmbedded


class TempsTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromStringToListHourEmbedded(data: String?): List<HourEmbedded> {
        if (data.isNullOrBlank()) {
            return emptyList()
        }
        val listType = object : TypeToken<List<HourEmbedded>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromListHourEmbeddedToString(list: List<HourEmbedded>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringToListForecastEmbedded(data: String?): List<ForecastEmbedded> {
        if (data.isNullOrBlank()) {
            return emptyList()
        }
        val listType = object : TypeToken<List<ForecastEmbedded>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromListForecastEmbeddedToString(list: List<ForecastEmbedded>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringToListAlertEmbedded(data: String?): List<AlertEmbedded> {
        if (data.isNullOrBlank()) {
            return emptyList()
        }
        val listType = object : TypeToken<List<AlertEmbedded>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromListAlertEmbeddedToString(list: List<AlertEmbedded>): String {
        return gson.toJson(list)
    }
}