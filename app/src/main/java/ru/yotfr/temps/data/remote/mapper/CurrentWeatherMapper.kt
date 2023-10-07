package ru.yotfr.temps.data.remote.mapper

import ru.yotfr.temps.data.remote.model.CurrentWeatherResponse
import ru.yotfr.temps.domain.model.CurrentWeather
import ru.yotfr.temps.domain.model.Temperature

fun CurrentWeatherResponse.mapToCurrentWeather(): CurrentWeather =
    CurrentWeather(
        weatherTypeModel = weatherType.mpToWeatherTypeModel(),
        temperature = Temperature(
            temperature = mainParameters.temperature,
            apparent = mainParameters.apparentTemperature,
            minimum = mainParameters.minimumTemperature,
            maximum = mainParameters.maximumTemperature
        ),
        pressure = mainParameters.pressure,
        humidityPercent = mainParameters.humidity,
        visibilityDistance = visibility,
        wind = windParameters.mapToWind()
    )