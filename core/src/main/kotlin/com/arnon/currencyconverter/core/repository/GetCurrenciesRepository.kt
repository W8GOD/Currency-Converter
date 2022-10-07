package com.arnon.currencyconverter.core.repository

import com.arnon.currencyconverter.core.database.exchangerate.CurrenciesDB
import com.arnon.currencyconverter.core.database.exchangerate.CurrenciesDBItem
import com.arnon.currencyconverter.core.database.exchangerate.ExchangeRatesDao
import com.arnon.currencyconverter.core.model.Currency
import com.arnon.currencyconverter.core.service.ApiExchangeRatesServiceHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCurrenciesRepository @Inject constructor(
    private val remoteDataSource: ApiExchangeRatesServiceHelper,
    private val exchangeRatesDao: ExchangeRatesDao
) {

    fun getResultFromLocalDataSource(): Flow<List<Currency>> {
        return exchangeRatesDao.getCurrencies().map { db ->
            db.currencies.map { Currency(it.symbol, it.name) }
        }
    }

    suspend fun getResultFromRemoteDataSource(): List<Currency> {
        return remoteDataSource.getCurrencies().apply {
            val currenciesDBItem = this.map { CurrenciesDBItem(it.key, it.value) }
            exchangeRatesDao.insert(CurrenciesDB(currencies = currenciesDBItem))
        }.let { response ->
            response.map { Currency(it.key, it.value) }
        }
    }
}