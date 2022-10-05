package com.arnon.currencyconverter

import com.arnon.currencyconverter.core.response.LatestExchangeRatesResponse

sealed class MainUiState {
    object Loading : MainUiState()
    data class Success(val value: LatestExchangeRatesResponse) : MainUiState()
    data class Failure(val message: String?) : MainUiState()
}