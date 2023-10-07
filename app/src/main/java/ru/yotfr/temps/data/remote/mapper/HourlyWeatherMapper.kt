package ru.yotfr.temps.data.remote.mapper

import ru.yotfr.temps.data.remote.model.WrappedHourlyForecastResponse
import ru.yotfr.temps.domain.model.DailyForecast
import ru.yotfr.temps.domain.model.HourlyWeather
import ru.yotfr.temps.domain.model.Temperature
import java.time.LocalDateTime

fun WrappedHourlyForecastResponse.mapToDailyForecast(): List<DailyForecast> =
    list.groupBy {
        LocalDateTime.parse(it.dateTime).toLocalDate()
    }.map {
        val hourlyForecast = it.value.map { hourlyWeatherResponse ->
            HourlyWeather(
                weatherTypeModel = hourlyWeatherResponse.weatherType.mpToWeatherTypeModel(),
                temperature = Temperature(
                    temperature = hourlyWeatherResponse.mainParameters.temperature,
                    apparent = hourlyWeatherResponse.mainParameters.apparentTemperature,
                    minimum = hourlyWeatherResponse.mainParameters.minimumTemperature,
                    maximum = hourlyWeatherResponse.mainParameters.maximumTemperature
                ),
                pressure = hourlyWeatherResponse.mainParameters.pressure,
                humidityPercent = hourlyWeatherResponse.mainParameters.humidity,
                cloudinessPercent = hourlyWeatherResponse.cloudiness.percent,
                visibilityDistance = hourlyWeatherResponse.visibility,
                wind = hourlyWeatherResponse.windParameters.mapToWind(),
                precipitationProbabilityPercent =
                (hourlyWeatherResponse.precipitationProbability * 100).toInt(),
                time = LocalDateTime.parse(hourlyWeatherResponse.dateTime).toLocalTime()
            )
        }
        DailyForecast(
            date = it.key,
            hourlyForecast = hourlyForecast
        )
    }