package com.arnon.currencyconverter.core.service

import com.arnon.currencyconverter.core.model.response.LatestExchangeRateResponse
import retrofit2.http.GET

interface ApiExchangeRatesService {
    @GET("api/latest.json")
    suspend fun getLatestExchangeRates(): LatestExchangeRateResponse
}