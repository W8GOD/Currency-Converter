package com.arnon.currencyconverter.ui

import com.arnon.currencyconverter.model.MainCurrency

sealed class CurrenciesUiState {
    object Loading : CurrenciesUiState()
    data class Success(val value: List<MainCurrency>) : CurrenciesUiState()
    data class Failure(val message: String?) : CurrenciesUiState()
}