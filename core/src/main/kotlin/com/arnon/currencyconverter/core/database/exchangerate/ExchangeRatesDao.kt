package com.arnon.currencyconverter.core.database.exchangerate

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExchangeRatesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: ExchangeRatesDB)

    @Query("SELECT * FROM exchange_rates")
    fun getExchangeRates(): ExchangeRatesDB?
}