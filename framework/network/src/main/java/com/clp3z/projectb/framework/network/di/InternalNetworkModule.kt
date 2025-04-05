package com.clp3z.projectb.framework.network.di

import com.clp3z.projectb.framework.network.service.BinanceService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InternalNetworkModule {

    private const val APPLICATION_JSON = "application/json"
    private const val HOST = "https://api.binance.com/"

    @Provides
    @Singleton
    fun provideJsonSerializer(): Json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideHttpInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        json: Json,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory(APPLICATION_JSON.toMediaType()))
            .baseUrl(HOST)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideBinanceService(retrofit: Retrofit): BinanceService =
        retrofit.create<BinanceService>()
}
