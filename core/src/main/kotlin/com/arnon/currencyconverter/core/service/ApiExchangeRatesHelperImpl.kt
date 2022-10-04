package com.arnon.currencyconverter.core.service

import com.arnon.currencyconverter.core.model.response.LatestExchangeRatesResponse
import retrofit2.Response
import javax.inject.Inject

class ApiExchangeRatesHelperImpl @Inject constructor(
    private val apiExchangeRatesService: ApiExchangeRatesService
) : ApiExchangeRatesHelper {

    override suspend fun getLatestExchangeRates(): Response<LatestExchangeRatesResponse> {
        return apiExchangeRatesService.getLatestExchangeRates()
    }
}