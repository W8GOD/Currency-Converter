package com.arnon.currencyconverter.core.database.exchangerate

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object CurrenciesDBConverter {
    private lateinit var dbExchangeRatesJsonAdapter: JsonAdapter<List<CurrenciesDBItem>>

    fun initialize(moshi: Moshi) {
        val response = Types.newParameterizedType(MutableList::class.java, CurrenciesDBItem::class.java)
        dbExchangeRatesJsonAdapter = moshi.adapter(response)
    }

    @TypeConverter
    @JvmStatic
    fun jsonToList(value: String): List<CurrenciesDBItem>? =
        dbExchangeRatesJsonAdapter.fromJson(value)

    @TypeConverter
    @JvmStatic
    fun listToJson(list: List<CurrenciesDBItem>?): String = dbExchangeRatesJsonAdapter.toJson(list)
}