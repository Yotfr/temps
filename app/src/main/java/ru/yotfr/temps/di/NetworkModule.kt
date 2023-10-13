package ru.yotfr.temps.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.yotfr.temps.data.datasource.remote.api.CurrentWeatherApi
import ru.yotfr.temps.data.datasource.remote.api.ForecastApi
import ru.yotfr.temps.data.datasource.remote.api.PlacesApi
import ru.yotfr.temps.data.datasource.remote.api.SearchApi
import ru.yotfr.temps.data.datasource.remote.interceptor.ApiKeyInterceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofitClient(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    internal fun provideCurrentWeatherApi(
        retrofit: Retrofit
    ): CurrentWeatherApi {
        return retrofit.create(CurrentWeatherApi::class.java)
    }

    @Provides
    @Singleton
    internal fun provideForecastApi(
        retrofit: Retrofit
    ): ForecastApi {
        return retrofit.create(ForecastApi::class.java)
    }

    @Provides
    @Singleton
    internal fun provideSearchApi(
        retrofit: Retrofit
    ): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }

    @Provides
    @Singleton
    internal fun providePlacesApi(
        retrofit: Retrofit
    ): PlacesApi {
        return retrofit.create(PlacesApi::class.java)
    }
}