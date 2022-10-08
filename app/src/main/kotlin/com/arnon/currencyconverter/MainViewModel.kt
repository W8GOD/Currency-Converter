package com.arnon.currencyconverter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnon.currencyconverter.core.CoreNetworkingProvider
import com.arnon.currencyconverter.core.model.ExchangeRate
import com.arnon.currencyconverter.core.model.LatestExchangeRate
import com.arnon.currencyconverter.model.MainCurrency
import com.arnon.currencyconverter.ui.CurrenciesUiState
import com.arnon.currencyconverter.ui.ExchangeRatesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import timber.log.Timber
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
        private const val CURRENCY_DEFAULT = "USD"
        private const val CURRENCY_ACTIVE = "USD"
    }

    private val _exchangeRatesUiState = MutableStateFlow<ExchangeRatesUiState>(ExchangeRatesUiState.Loading)
    val exchangeRatesUiState: StateFlow<ExchangeRatesUiState> = _exchangeRatesUiState

    private val _currenciesUiState = MutableStateFlow<CurrenciesUiState>(CurrenciesUiState.Loading)
    val currenciesUiState: StateFlow<CurrenciesUiState> = _currenciesUiState

    private val _baseAmount = MutableStateFlow(BASE_AMOUNT_TEXT_DEFAULT)
    val baseAmount = _baseAmount.asStateFlow()

    private var _baseExchangeRates = LatestExchangeRate()

    val currencyDefault = CURRENCY_DEFAULT
    val currencyListDefault = listOf(MainCurrency(CURRENCY_DEFAULT, true))

    init {
        fetchCurrencies()
        refreshExchangeRates()
    }

    fun setBaseAmount(baseAmount: String) {
        _baseAmount.value = baseAmount
        calculateRates()
    }

    private fun calculateRates() {
        if (_exchangeRatesUiState.value is ExchangeRatesUiState.Success && _baseAmount.value.isNotEmpty()) {
            val stateValue = (_exchangeRatesUiState.value as ExchangeRatesUiState.Success).value
            val newRates = _baseExchangeRates.rates.map {
                ExchangeRate(
                    it.symbol,
                    (it.value * (_baseAmount.value.toDoubleOrNull() ?: BASE_AMOUNT_DEFAULT))
                )
            }
            _exchangeRatesUiState.value =
                ExchangeRatesUiState.Success(stateValue.copy(rates = newRates))
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

    private fun fetchCurrencies() = viewModelScope.launch(Dispatchers.IO) {
        provider.getCurrenciesRepository.getResultFromRemoteDataSource().let { getCurrencies() }
    }

    private fun getCurrencies() = viewModelScope.launch(Dispatchers.IO) {
        _currenciesUiState.value = CurrenciesUiState.Loading
        provider.getCurrenciesRepository.getResultFromLocalDataSource()
            .catch { throwable ->
                _currenciesUiState.value = CurrenciesUiState.Failure(throwable.message)
                Timber.d(throwable)
            }.collect { currencyList ->
                currencyList.map {
                    // For the free account, API only supports UDS exchange rates.
                    if (it.symbol == CURRENCY_ACTIVE) {
                        MainCurrency(it.symbol, true)
                    } else {
                        MainCurrency(it.symbol, false)
                    }
                }.let {
                    _currenciesUiState.value = CurrenciesUiState.Success(it)
                }
            }
    }

    private fun fetchExchangeRates() = viewModelScope.launch(Dispatchers.IO) {
        provider.getExchangeRatesRepository.getResultFromRemoteDataSource()
            .let { getExchangeRates() }
    }

    private fun getExchangeRates() = viewModelScope.launch(Dispatchers.IO) {
        _exchangeRatesUiState.value = ExchangeRatesUiState.Loading
        provider.getExchangeRatesRepository.getResultFromLocalDataSource()
            .catch { throwable ->
                _exchangeRatesUiState.value = ExchangeRatesUiState.Failure(throwable.message)
                Timber.d(throwable)
            }.collect {
                _baseExchangeRates = it
                _exchangeRatesUiState.value = ExchangeRatesUiState.Success(_baseExchangeRates)
            }
    }
}