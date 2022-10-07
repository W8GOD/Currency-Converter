package com.arnon.currencyconverter.core.service

import com.arnon.currencyconverter.core.model.response.LatestExchangeRateResponse
import javax.inject.Inject

class ApiExchangeRatesServiceHelperImpl @Inject constructor(
    private val apiExchangeRatesService: ApiExchangeRatesService
) : ApiExchangeRatesServiceHelper {

    override suspend fun getLatestExchangeRates(): LatestExchangeRateResponse {
        return apiExchangeRatesService.getLatestExchangeRates()
    }

    override suspend fun getCurrencies(): Map<String, String> {
        return apiExchangeRatesService.getCurrencies()
    }
}