package com.arnon.currencyconverter.ui

import com.arnon.currencyconverter.core.model.LatestExchangeRate

sealed class ExchangeRatesUiState {
    object Loading : ExchangeRatesUiState()
    data class Success(val value: LatestExchangeRate) : ExchangeRatesUiState()
    data class Failure(val message: String?) : ExchangeRatesUiState()
}