package com.arnon.currencyconverter.core.service

import com.arnon.currencyconverter.core.model.response.LatestExchangeRatesResponse
import retrofit2.Response

interface ApiExchangeRatesHelper {
    suspend fun getLatestExchangeRates(): Response<LatestExchangeRatesResponse>
}