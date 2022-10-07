package com.arnon.currencyconverter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnon.currencyconverter.core.CoreNetworkingProvider
import com.arnon.currencyconverter.core.model.ExchangeRate
import com.arnon.currencyconverter.core.model.LatestExchangeRate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import javax.inject.Inject
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@HiltViewModel
class MainViewModel @Inject constructor(
    private val provider: CoreNetworkingProvider
) : ViewModel() {

    companion object {
        private const val TIME_EXCHANGE_RATES_IN_MINUTES = 30
        private const val BASE_AMOUNT_DEFAULT = 1.0
        private const val BASE_AMOUNT_TEXT_DEFAULT = "1"
    }

    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Loading)
    val uiState: StateFlow<MainUiState> = _uiState

    private val _baseAmount = MutableStateFlow(BASE_AMOUNT_TEXT_DEFAULT)
    val baseAmount = _baseAmount.asStateFlow()

    private var _baseExchangeRates = LatestExchangeRate()

    init {
        refreshExchangeRates()
    }

    fun setBaseAmount(baseAmount: String) {
        _baseAmount.value = baseAmount
        calculateRates()
    }

    private fun calculateRates() {
        if (_uiState.value is MainUiState.Success && _baseAmount.value.isNotEmpty()) {
            val stateValue = (_uiState.value as MainUiState.Success).value
            val newRates = _baseExchangeRates.rates.map {
                ExchangeRate(
                    it.symbol,
                    (it.value * (_baseAmount.value.toDoubleOrNull() ?: BASE_AMOUNT_DEFAULT))
                )
            }
            _uiState.value = MainUiState.Success(stateValue.copy(rates = newRates))
        }
    }

    private fun refreshExchangeRates(): Job {
        return viewModelScope.launch {
            while (isActive) {
                fetchExchangeRates()
                delay(TIME_EXCHANGE_RATES_IN_MINUTES.toDuration(DurationUnit.MINUTES))
            }
        }
    }

    private fun fetchExchangeRates() = viewModelScope.launch(Dispatchers.IO) {
        provider.getExchangeRatesRepository.getResultFromRemoteDataSource()
            .let { getExchangeRates() }
    }

    private fun getExchangeRates() = viewModelScope.launch(Dispatchers.IO) {
        _uiState.value = MainUiState.Loading
        provider.getExchangeRatesRepository.getResultFromLocalDataSource().catch {
            _uiState.value = MainUiState.Failure(it.message)
        }.collect {
            _baseExchangeRates = it
            _uiState.value = MainUiState.Success(_baseExchangeRates)
        }
    }
}