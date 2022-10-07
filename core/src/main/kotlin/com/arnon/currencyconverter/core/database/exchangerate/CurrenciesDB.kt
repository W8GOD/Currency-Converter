package com.arnon.currencyconverter.core.database.exchangerate

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies")
class CurrenciesDB(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val currencies: List<CurrenciesDBItem> = emptyList()
)