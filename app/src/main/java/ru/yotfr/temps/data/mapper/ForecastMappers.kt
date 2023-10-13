package ru.yotfr.temps.data.mapper

import ru.yotfr.temps.data.datasource.local.entity.ForecastEntity
import ru.yotfr.temps.data.datasource.local.entity.embedded.AlertEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.AstroEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.CurrentWeatherEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.DayEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.ForecastEmbedded
import ru.yotfr.temps.data.datasource.local.entity.embedded.HourEmbedded
import ru.yotfr.temps.data.datasource.remote.model.AlertResponseObject
import ru.yotfr.temps.data.datasource.remote.model.AstroResponseObject
import ru.yotfr.temps.data.datasource.remote.model.CurrentResponseObject
import ru.yotfr.temps.data.datasource.remote.model.DayResponseObject
import ru.yotfr.temps.data.datasource.remote.model.ForecastDayResponseObject
import ru.yotfr.temps.data.datasource.remote.model.ForecastResponse
import ru.yotfr.temps.data.datasource.remote.model.HourResponseObject
import ru.yotfr.temps.domain.model.Alert
import ru.yotfr.temps.domain.model.Astro
import ru.yotfr.temps.domain.model.CurrentWeather
import ru.yotfr.temps.domain.model.Day
import ru.yotfr.temps.domain.model.ForecastDay
import ru.yotfr.temps.domain.model.ForecastModel
import ru.yotfr.temps.domain.model.Hour
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun ForecastResponse.mapToEntity(
    placeId: String
): ForecastEntity =
    ForecastEntity(
        placeId = placeId,
        current = current.mapToCurrentWeatherEmbedded(),
        forecast = forecast.forecastday.map {
            it.mapToForecastEmbedded()
        },
        alerts = alerts.alert.map {
            it.mapToAlertEmbedded()
        }
    )

fun CurrentResponseObject.mapToCurrentWeatherEmbedded(): CurrentWeatherEmbedded =
    CurrentWeatherEmbedded(
        updateTimeEpoch = updateTimeEpoch,
        updateTime = updateTime,
        tempC = tempC,
        tempF = tempF,
        isDay = isDay,
        condition = condition.mapToConditionEmbedded(),
        windMph = windMph,
        windKph = windKph,
        windDegree = windDegree,
        windDirection = windDirection,
        pressureMb = pressureMb,
        pressureIn = pressureIn,
        precipMm = precipMm,
        precipIn = precipIn,
        humidityPercent = humidityPercent,
        cloudPercent = cloudPercent,
        feelsLikeC = feelsLikeC,
        feelsLikeF = feelsLikeF,
        visibilityKm = visibilityKm,
        visibilityMiles = visibilityMiles,
        uvIndex = uvIndex,
        gustMph = gustMph,
        gustKph = gustKph,
        airQuality = airQuality.mapToAirQualityEmbedded()
    )

fun ForecastDayResponseObject.mapToForecastEmbedded(): ForecastEmbedded {
    return ForecastEmbedded(
        date = date,
        dateEpoch = dateEpoch,
        day = day.mapToDayEmbedded(),
        astro = astro.mapToAstroEmbedded(),
        hour = hour.map {
            it.mapToHourEmbedded()
        }
    )
}

fun DayResponseObject.mapToDayEmbedded(): DayEmbedded {
    return DayEmbedded(
        maxTempC = maxTempC,
        maxTempF = maxTempF,
        minTempC = minTempC,
        minTempF = minTempF,
        avgTempC = avgTempC,
        avgTempF = avgTempF,
        maxWindMph = maxWindMph,
        maxWindKph = maxWindKph,
        totalPrecipMm = totalPrecipMm,
        totalPrecipIn = totalPrecipIn,
        totalSnowCm = totalSnowCm,
        avgVisibilityKm = avgVisibilityKm,
        avgVisibilityMiles = avgVisibilityMiles,
        dailyWillItRain = dailyWillItRain,
        dailyChanceOfRain = dailyChanceOfRain,
        dailyWillItSnow = dailyWillItSnow,
        condition = condition.mapToConditionEmbedded(),
        dailyChanceOfSnow = dailyChanceOfRain,
        uv = uv,
        airQuality = airQuality.mapToAirQualityEmbedded()
    )
}

fun AstroResponseObject.mapToAstroEmbedded(): AstroEmbedded {
    return AstroEmbedded(
        sunrise = sunrise,
        sunset = sunset,
        moonrise = moonrise,
        moonset = moonset,
        moonPhase = moonPhase,
        moonIlluminationPercent = moonIlluminationPercent,
        isMoonUp = isMoonUp,
        isSunUp = isSunUp
    )
}

fun HourResponseObject.mapToHourEmbedded(): HourEmbedded {
    return HourEmbedded(
        timeEpoch = timeEpoch,
        time = time,
        tempC = tempC,
        tempF = tempF,
        isDay = isDay,
        condition = condition.mapToConditionEmbedded(),
        windMph = windMph,
        windKph = windKph,
        windDegree = windDegree,
        windDirection = windDirection,
        pressureMb = pressureMb,
        pressureIn = pressureIn,
        precipMm = precipMm,
        precipIn = precipIn,
        humidityPercent = humidityPercent,
        cloudPercent = cloudPercent,
        feelsLikeC = feelsLikeC,
        feelsLikeF = feelsLikeF,
        windChillC = windChillC,
        windChillF = windChillF,
        heatIndexC = heatIndexC,
        heatIndexF = heatIndexF,
        dewPointC = dewPointC,
        dewPointF = dewPointF,
        willItRain = willItRain,
        chanceOfRain = chanceOfRain,
        willItSnow = willItSnow,
        chanceOfSnow = chanceOfSnow,
        visibilityKm = visibilityKm,
        visibilityMiles = visibilityMiles,
        uvIndex = uvIndex,
        gustMph = gustMph,
        gustKph = gustKph,
        airQuality = airQuality.mapToAirQualityEmbedded()
    )
}

fun AlertResponseObject.mapToAlertEmbedded(): AlertEmbedded {
    return AlertEmbedded(
        headline = headline,
        msgType = msgType,
        severity = severity,
        urgency = urgency,
        areas = areas,
        category = category,
        certainty = certainty,
        event = event,
        note = note,
        effective = effective,
        expires = expires,
        desc = desc,
        instruction = instruction
    )
}


fun ForecastEntity.mapToForecastModel(): ForecastModel {
    return ForecastModel(
        placeId = placeId,
        current = current.mapToCurrentWeather(),
        forecast = forecast.map {
            it.mapToForecastDay()
        },
        alerts = alerts.map {
            it.mapToAlert()
        }
    )
}

fun CurrentWeatherEmbedded.mapToCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        updateTimeEpoch = updateTimeEpoch,
        updateTime = LocalDateTime.parse(
            updateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        ),
        tempC = tempC,
        tempF = tempF,
        isDay = isDay.toBoolean(),
        condition = condition.mapToCondition(),
        windMph = windMph,
        windKph = windKph,
        windDegree = windDegree,
        windDirection = windDirection.toWindDirection(),
        pressureMb = pressureMb,
        pressureIn = pressureIn,
        precipMm = precipMm,
        precipIn = precipIn,
        humidityPercent = humidityPercent,
        cloudPercent = cloudPercent,
        feelsLikeC = feelsLikeC,
        feelsLikeF = feelsLikeF,
        visibilityKm = visibilityKm,
        visibilityMiles = visibilityMiles,
        uvIndex = uvIndex,
        gustMph = gustMph,
        gustKph = gustKph,
        airQuality = airQuality.mapToAirQuality()
    )
}

fun Int.toBoolean(): Boolean {
    return this == 1
}

fun ForecastEmbedded.mapToForecastDay(): ForecastDay {
    return ForecastDay(
        date = LocalDate.parse(
            date, DateTimeFormatter.ofPattern("yyyy-MM-dd")
        ),
        dateEpoch = dateEpoch,
        day = day.mapToDay(),
        astro = astro.mapToAstro(),
        hour = hour.map {
            it.mapToHour()
        }
    )
}

fun DayEmbedded.mapToDay(): Day {
    return Day(
        maxTempC = maxTempC,
        maxTempF = maxTempF,
        minTempC = minTempC,
        minTempF = minTempF,
        avgTempC = avgTempC,
        avgTempF = avgTempF,
        maxWindMph = maxWindMph,
        maxWindKph = maxWindKph,
        totalPrecipMm = totalPrecipMm,
        totalPrecipIn = totalPrecipIn,
        totalSnowCm = totalSnowCm,
        avgVisibilityKm = avgVisibilityKm,
        avgVisibilityMiles = avgVisibilityMiles,
        dailyWillItRain = dailyWillItRain.toBoolean(),
        dailyChanceOfRain = dailyChanceOfRain,
        dailyWillItSnow = dailyWillItSnow.toBoolean(),
        condition = condition.mapToCondition(),
        dailyChanceOfSnow = dailyChanceOfRain,
        uv = uv,
        airQuality = airQuality.mapToAirQuality()
    )
}

fun AstroEmbedded.mapToAstro(): Astro {
    return Astro(
        sunrise = LocalTime.parse(
            sunrise, DateTimeFormatter.ofPattern("hh:mm aaa")
        ),
        sunset = LocalTime.parse(
            sunset, DateTimeFormatter.ofPattern("hh:mm aaa")
        ),
        moonrise = LocalTime.parse(
            moonrise, DateTimeFormatter.ofPattern("hh:mm aaa")
        ),
        moonset = LocalTime.parse(
            moonset, DateTimeFormatter.ofPattern("hh:mm aaa")
        ),
        moonPhase = moonPhase.toMoonPhase(),
        moonIlluminationPercent = moonIlluminationPercent.toInt(),
        isMoonUp = isMoonUp.toBoolean(),
        isSunUp = isSunUp.toBoolean()
    )
}


fun HourEmbedded.mapToHour(): Hour {
    return Hour(
        timeEpoch = timeEpoch,
        time = LocalDateTime.parse(
            time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        ),
        tempC = tempC,
        tempF = tempF,
        isDay = isDay.toBoolean(),
        condition = condition.mapToCondition(),
        windMph = windMph,
        windKph = windKph,
        windDegree = windDegree,
        windDirection = windDirection.toWindDirection(),
        pressureMb = pressureMb,
        pressureIn = pressureIn,
        precipMm = precipMm,
        precipIn = precipIn,
        humidityPercent = humidityPercent,
        cloudPercent = cloudPercent,
        feelsLikeC = feelsLikeC,
        feelsLikeF = feelsLikeF,
        windChillC = windChillC,
        windChillF = windChillF,
        heatIndexC = heatIndexC,
        heatIndexF = heatIndexF,
        dewPointC = dewPointC,
        dewPointF = dewPointF,
        willItRain = willItRain.toBoolean(),
        chanceOfRain = chanceOfRain,
        willItSnow = willItSnow.toBoolean(),
        chanceOfSnow = chanceOfSnow,
        visibilityKm = visibilityKm,
        visibilityMiles = visibilityMiles,
        uvIndex = uvIndex,
        gustMph = gustMph,
        gustKph = gustKph,
        airQuality = airQuality.mapToAirQuality()
    )
}

fun AlertEmbedded.mapToAlert(): Alert {
    return Alert(
        headline = headline,
        msgType = msgType,
        severity = severity,
        urgency = urgency,
        areas = areas,
        category = category,
        certainty = certainty,
        event = event,
        note = note,
        effective = effective,
        expires = expires,
        desc = desc,
        instruction = instruction
    )
}


