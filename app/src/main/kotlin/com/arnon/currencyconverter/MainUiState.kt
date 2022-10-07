package com.arnon.currencyconverter

import com.arnon.currencyconverter.core.model.LatestExchangeRate

sealed class MainUiState {
    object Loading : MainUiState()
    data class Success(val value: LatestExchangeRate) : MainUiState()
    data class Failure(val message: String?) : MainUiState()
}