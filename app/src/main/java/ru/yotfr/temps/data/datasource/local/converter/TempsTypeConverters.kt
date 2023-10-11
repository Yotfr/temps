package ru.yotfr.temps.data.datasource.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.yotfr.temps.data.datasource.local.entity.embedded.DailyWeatherEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.HourlyWeatherEmbedded
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter


class TempsTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromStringToHourlyWeatherList(data: String?): List<HourlyWeatherEmbedded> {
        if (data.isNullOrBlank()) {
            return emptyList()
        }
        val listType = object : TypeToken<List<HourlyWeatherEmbedded>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromHourlyWeatherListToString(list: List<HourlyWeatherEmbedded>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringToDailyWeatherList(data: String?): List<DailyWeatherEmbedded> {
        if (data.isNullOrBlank()) {
            return emptyList()
        }
        val listType = object : TypeToken<List<DailyWeatherEmbedded>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromDailyWeatherListToString(list: List<DailyWeatherEmbedded>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromLocalDateToString(localDate: LocalDate): String {
        return localDate.format(DateTimeFormatter.ISO_DATE)
    }

    @TypeConverter
    fun fromStringToLocalDate(data: String): LocalDate {
        return LocalDate.parse(data, DateTimeFormatter.ISO_DATE)
    }

    @TypeConverter
    fun fromLocalTimeToString(localTime: LocalTime): String {
        return localTime.format(DateTimeFormatter.ISO_TIME)
    }

    @TypeConverter
    fun fromStringToLocalTime(data: String): LocalTime {
        return LocalTime.parse(data, DateTimeFormatter.ISO_TIME)
    }
}