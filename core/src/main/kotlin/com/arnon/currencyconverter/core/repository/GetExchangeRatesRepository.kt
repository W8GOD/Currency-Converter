package com.arnon.currencyconverter.core.repository

import com.arnon.currencyconverter.common.util.base.BaseRepository
import com.arnon.currencyconverter.core.database.exchangerate.ExchangeRatesDB
import com.arnon.currencyconverter.core.database.exchangerate.ExchangeRatesDao
import com.arnon.currencyconverter.core.database.exchangerate.RateDBItem
import com.arnon.currencyconverter.core.response.LatestExchangeRatesResponse
import com.arnon.currencyconverter.core.service.ApiExchangeRatesServiceHelper
import javax.inject.Inject

class GetExchangeRatesRepository @Inject constructor(
    private val remoteDataSource: ApiExchangeRatesServiceHelper,
    private val exchangeRatesDao: ExchangeRatesDao,
) : BaseRepository<LatestExchangeRatesResponse>() {

    override suspend fun getResultFromLocalDataSource(): LatestExchangeRatesResponse {
        return exchangeRatesDao.getExchangeRates()?.let { exchangeRatesDB ->
            with(exchangeRatesDB) {
                val mapRates = rates.associate { it.currency to it.value }
                LatestExchangeRatesResponse(base, timestamp, mapRates)
            }
        } ?: run {
            LatestExchangeRatesResponse()
        }
    }

    override suspend fun getResultFromRemoteDataSource(): LatestExchangeRatesResponse {
        return remoteDataSource.getLatestExchangeRates().apply {
            with(this) {
                val exchangeRates = ExchangeRatesDB(base, timestamp, mapToRates(rates))
                exchangeRatesDao.insert(exchangeRates)
            }
        }
    }

    private fun mapToRates(responseBody: Map<String, Double>): List<RateDBItem> {
        return responseBody.map { RateDBItem(it.key, it.value) }
    }
}
