package com.arnon.currencyconverter.core.database.exchangerate

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExchangeRatesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: ExchangeRatesDB)

    @Query("SELECT * FROM exchange_rates")
    fun getLatestExchangeRates(): Flow<ExchangeRatesDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: CurrenciesDB)

    @Query("SELECT * FROM currencies")
    fun getCurrencies(): Flow<CurrenciesDB>
}