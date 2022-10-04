package com.arnon.currencyconverter.core.repository

import com.arnon.currencyconverter.core.model.response.LatestExchangeRatesResponse
import com.arnon.currencyconverter.core.service.ApiExchangeRatesHelper
import retrofit2.Response
import javax.inject.Inject

class GetExchangeRatesRepository @Inject constructor(
    private val exchangeRatesHelper: ApiExchangeRatesHelper
) {
    suspend fun getExchangeRates(): Response<LatestExchangeRatesResponse> {
        return exchangeRatesHelper.getLatestExchangeRates()
    }
}