package ru.yotfr.temps.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.yotfr.temps.data.location.LocationProviderImpl
import ru.yotfr.temps.data.repository.PlacesRepositoryImpl
import ru.yotfr.temps.data.repository.WeatherRepositoryImpl
import ru.yotfr.temps.domain.location.LocationProvider
import ru.yotfr.temps.domain.repository.PlacesRepository
import ru.yotfr.temps.domain.repository.WeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppBindModule {

    @Binds
    @Singleton
    fun bindPlacesRepository(
        placesRepositoryImpl: PlacesRepositoryImpl
    ): PlacesRepository

    @Binds
    @Singleton
    fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    @Binds
    @Singleton
    fun bindLocationProvider(
        locationProviderImpl: LocationProviderImpl
    ): LocationProvider
}