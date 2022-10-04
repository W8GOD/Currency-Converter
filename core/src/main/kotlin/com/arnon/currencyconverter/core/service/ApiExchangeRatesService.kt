package com.arnon.currencyconverter.core.service

import com.arnon.currencyconverter.core.model.response.LatestExchangeRatesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiExchangeRatesService {
    @GET("api/latest.json")
    suspend fun getLatestExchangeRates(): Response<LatestExchangeRatesResponse>
}