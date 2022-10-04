package com.arnon.currencyconverter.core.di

import com.arnon.currencyconverter.core.BuildConfig
import com.arnon.currencyconverter.core.constant.Constants
import com.arnon.currencyconverter.core.service.ApiExchangeRatesHelperImpl
import com.arnon.currencyconverter.core.service.ApiExchangeRatesService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun getGson(): Gson = GsonBuilder().serializeNulls().setLenient().create()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
            OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        } else {
            OkHttpClient.Builder().build()
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiExchangeRatesService(retrofit: Retrofit): ApiExchangeRatesService {
        return retrofit.create(ApiExchangeRatesService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiExchangeRatesHelper(apiHelper: ApiExchangeRatesHelperImpl) = apiHelper
}