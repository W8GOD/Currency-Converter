package com.arnon.currencyconverter.core.service

import com.arnon.currencyconverter.core.model.response.LatestExchangeRateResponse

interface ApiExchangeRatesServiceHelper {
    suspend fun getLatestExchangeRates(): LatestExchangeRateResponse
}