package com.arnon.currencyconverter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnon.currencyconverter.core.CoreNetworkingProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val provider: CoreNetworkingProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Loading)
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        fetchExchangeRates()
        getExchangeRates()
    }

    private fun fetchExchangeRates() = viewModelScope.launch(Dispatchers.IO) {
        provider.getExchangeRatesRepository.getResultFromRemoteDataSource()
    }

    private fun getExchangeRates() = viewModelScope.launch(Dispatchers.IO) {
        _uiState.value = MainUiState.Loading
        provider.getExchangeRatesRepository.getResultFromLocalDataSource().let { response ->
            _uiState.value = MainUiState.Success(response)
        }
    }
}