package ru.yotfr.temps.data.mapper

import ru.yotfr.temps.data.datasource.local.entity.embedded.AirQualityEmbedded
import ru.yotfr.temps.data.datasource.remote.model.AirQualityResponseObject
import ru.yotfr.temps.domain.model.AirQuality

fun AirQualityResponseObject.mapToAirQualityEmbedded(): AirQualityEmbedded {
    return AirQualityEmbedded(
        co = co,
        no2 = no2,
        o3 = o3,
        so2 =so2,
        pm2 = pm2,
        pm10 = pm10,
        usIndex = usIndex,
        gbIndex = gbIndex
    )
}

fun AirQualityEmbedded.mapToAirQuality(): AirQuality {
    return AirQuality(
        co = co,
        no2 = no2,
        o3 = o3,
        so2 =so2,
        pm2 = pm2,
        pm10 = pm10,
        usIndex = usIndex,
        gbIndex = gbIndex
    )
}