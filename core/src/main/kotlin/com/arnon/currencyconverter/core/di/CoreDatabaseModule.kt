package com.arnon.currencyconverter.core.di

import android.content.Context
import androidx.room.Room
import com.arnon.currencyconverter.core.BuildConfig
import com.arnon.currencyconverter.core.database.AppDatabase
import com.arnon.currencyconverter.core.database.exchangerate.ExchangeRatesDBConverter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreDatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(context: Context, moshi: Moshi): AppDatabase {
        ExchangeRatesDBConverter.initialize(moshi)
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            BuildConfig.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideExchangeRatesDao(db: AppDatabase) = db.exchangeRatesDao()
}