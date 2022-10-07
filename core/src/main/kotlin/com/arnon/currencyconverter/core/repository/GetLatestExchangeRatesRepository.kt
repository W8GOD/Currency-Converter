package com.arnon.currencyconverter.core.repository

import com.arnon.currencyconverter.core.database.exchangerate.ExchangeRatesDB
import com.arnon.currencyconverter.core.database.exchangerate.ExchangeRatesDao
import com.arnon.currencyconverter.core.database.exchangerate.RateDBItem
import com.arnon.currencyconverter.core.model.ExchangeRate
import com.arnon.currencyconverter.core.model.LatestExchangeRate
import com.arnon.currencyconverter.core.service.ApiExchangeRatesServiceHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetLatestExchangeRatesRepository @Inject constructor(
    private val remoteDataSource: ApiExchangeRatesServiceHelper,
    private val exchangeRatesDao: ExchangeRatesDao
) {

    fun getResultFromLocalDataSource(): Flow<LatestExchangeRate> {
        return exchangeRatesDao.getLatestExchangeRates().map { db ->
            val rates = db.rates.map { ExchangeRate(it.currency, it.value) }
            LatestExchangeRate(db.base, db.timestamp, rates)
        }
    }

    suspend fun getResultFromRemoteDataSource(): LatestExchangeRate {
        return remoteDataSource.getLatestExchangeRates().apply {
            val exchangeRates = ExchangeRatesDB(base, timestamp, mapToRateDBItem(rates))
            exchangeRatesDao.insert(exchangeRates)
        }.let { response ->
            val rates = response.rates.map { ExchangeRate(it.key, it.value) }
            LatestExchangeRate(response.base, response.timestamp, rates)
        }
    }

    private fun mapToRateDBItem(responseBody: Map<String, Double>): List<RateDBItem> {
        return responseBody.map { RateDBItem(it.key, it.value) }
    }
}
