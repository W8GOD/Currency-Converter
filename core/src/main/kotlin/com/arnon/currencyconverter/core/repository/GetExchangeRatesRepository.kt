package com.arnon.currencyconverter.core.repository

import com.arnon.currencyconverter.core.service.ApiExchangeRatesHelper
import javax.inject.Inject

class GetExchangeRatesRepository @Inject constructor(
    private val exchangeRatesHelper: ApiExchangeRatesHelper
) {

    suspend fun getExchangeRates(): String {
        return exchangeRatesHelper.getLatestExchangeRates().let {
            it.body()?.base ?: ""
        }
    }
}