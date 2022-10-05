package com.arnon.currencyconverter.core.database.exchangerate

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object ExchangeRatesDBConverter {
    private lateinit var dbExchangeRatesJsonAdapter: JsonAdapter<List<RateDBItem>>

    fun initialize(moshi: Moshi) {
        val response = Types.newParameterizedType(MutableList::class.java, RateDBItem::class.java)
        dbExchangeRatesJsonAdapter = moshi.adapter(response)
    }

    @TypeConverter
    @JvmStatic
    fun jsonToList(value: String): List<RateDBItem>? = dbExchangeRatesJsonAdapter.fromJson(value)

    @TypeConverter
    @JvmStatic
    fun listToJson(list: List<RateDBItem>?): String = dbExchangeRatesJsonAdapter.toJson(list)
}