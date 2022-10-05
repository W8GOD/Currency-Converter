package com.arnon.currencyconverter.core.service

import com.arnon.currencyconverter.core.response.LatestExchangeRatesResponse
import javax.inject.Inject

class ApiExchangeRatesServiceHelperImpl @Inject constructor(
    private val apiExchangeRatesService: ApiExchangeRatesService
) : ApiExchangeRatesServiceHelper {

    override suspend fun getLatestExchangeRates(): LatestExchangeRatesResponse {
        return apiExchangeRatesService.getLatestExchangeRates()
    }
}