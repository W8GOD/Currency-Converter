package com.arnon.currencyconverter.ui.views

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arnon.currencyconverter.MainUiState
import com.arnon.currencyconverter.MainViewModel

@Composable
fun BodyContent(
    context: Context,
    modifier: Modifier,
    mainViewModel: MainViewModel
) {
    val scrollState = rememberScrollState()
    var baseAmount by rememberSaveable { mutableStateOf("1") }
    val currencies = listOf("USD")
    val currencyDefault = "USD"

    Column {
        Column(modifier = Modifier.padding(24.dp, 0.dp)) {
            RateTextField(
                modifier,
                readOnly = false,
                value = baseAmount,
                enabled = true,
                onBaseAmountChanged = { newBaseAmount -> baseAmount = newBaseAmount }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                CurrencyPicker(
                    modifier,
                    readOnly = false,
                    enabled = true,
                    defaultSymbol = currencyDefault,
                    currencySymbols = currencies,
                    onSymbolSelected = { }
                )
            }
            Column(modifier = Modifier.padding(24.dp, 0.dp)) {
                when (val stateValue = mainViewModel.uiState.collectAsState().value) {
                    is MainUiState.Loading -> {
                        Toast.makeText(context, "Loading", Toast.LENGTH_SHORT)
                    }
                    is MainUiState.Success -> {
                        CurrencyContent(stateValue.value.rates)
                    }
                    is MainUiState.Failure -> {
                        Toast.makeText(context, "Failed", Toast.LENGTH_SHORT)
                    }
                }
            }
        }
    }
}

