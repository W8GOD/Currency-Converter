package com.arnon.currencyconverter.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arnon.currencyconverter.core.BuildConfig
import com.arnon.currencyconverter.core.database.exchangerate.*

@Database(
    entities = [ExchangeRatesDB::class, CurrenciesDB::class],
    version = BuildConfig.DATABASE_VERSION,
    exportSchema = BuildConfig.DATABASE_EXPORT_SCHEMA
)
@TypeConverters(ExchangeRatesDBConverter::class, CurrenciesDBConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun exchangeRatesDao(): ExchangeRatesDao
}