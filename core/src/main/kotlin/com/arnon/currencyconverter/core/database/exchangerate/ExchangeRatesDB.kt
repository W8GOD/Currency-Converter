package com.arnon.currencyconverter.core.database.exchangerate

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exchange_rates")
class ExchangeRatesDB(
    @PrimaryKey val base: String = "exchange_rates",
    val timestamp: Long = 0,
    val rates: List<RateDBItem>
)