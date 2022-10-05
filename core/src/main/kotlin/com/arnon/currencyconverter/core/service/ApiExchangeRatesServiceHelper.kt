package com.arnon.currencyconverter.core.service

import com.arnon.currencyconverter.core.response.LatestExchangeRatesResponse

interface ApiExchangeRatesServiceHelper {
    suspend fun getLatestExchangeRates(): LatestExchangeRatesResponse
}