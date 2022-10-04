package com.arnon.currencyconverter.core.di

import com.arnon.currencyconverter.core.BuildConfig
import com.arnon.currencyconverter.core.constant.Constants.AUTHORIZATION_HEADER
import com.arnon.currencyconverter.core.service.ApiExchangeRatesHelper
import com.arnon.currencyconverter.core.service.ApiExchangeRatesHelperImpl
import com.arnon.currencyconverter.core.service.ApiExchangeRatesService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_API_URL

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor { chain ->
                    val chainBuilder = chain.request().newBuilder()
                    chainBuilder.addHeader(AUTHORIZATION_HEADER, BuildConfig.APP_ID)
                    chain.proceed(chainBuilder.build())
                }
        } else {
            OkHttpClient.Builder()
        }.build()
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi, BASE_URL: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiExchangeRatesService(retrofit: Retrofit): ApiExchangeRatesService {
        return retrofit.create(ApiExchangeRatesService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiExchangeRatesHelper(apiExchangeRatesHelperImpl: ApiExchangeRatesHelperImpl): ApiExchangeRatesHelper {
        return apiExchangeRatesHelperImpl
    }
}