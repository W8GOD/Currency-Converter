package com.arnon.currencyconverter.ui.views

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arnon.currencyconverter.MainViewModel
import com.arnon.currencyconverter.ui.CurrenciesUiState
import com.arnon.currencyconverter.ui.ExchangeRatesUiState
import com.arnon.currencyconverter.ui.theme.Blue

@ExperimentalFoundationApi
@Composable
fun BodyContent(
    context: Context, modifier: Modifier, mainViewModel: MainViewModel
) {
    val currencyDefault = mainViewModel.currencyDefault
    val currencyListDefault = mainViewModel.currencyListDefault
    val currencies = (mainViewModel.currenciesUiState.collectAsState().value as? CurrenciesUiState.Success)

    Column(modifier = Modifier.padding(16.dp, 0.dp)) {
        Text(
            text = "Currency Converter",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center, color = Blue)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
        ) {
            Box(modifier = Modifier.weight(0.7f)) {
                RateTextField(readOnly = false,
                    value = mainViewModel.baseAmount.collectAsState().value,
                    enabled = true,
                    onBaseAmountChanged = { mainViewModel.setBaseAmount(it) })
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .widthIn(min = 100.dp)
            ) {
                CurrencyPicker(modifier,
                    readOnly = false,
                    enabled = true,
                    defaultSymbol = currencyDefault,
                    currencyList = currencies?.value ?: currencyListDefault,
                    onSymbolSelected = {
                        //No op
                    })
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (val stateValue = mainViewModel.exchangeRatesUiState.collectAsState().value) {
                is ExchangeRatesUiState.Loading -> {
                    Box { ProgressIndicator() }
                }
                is ExchangeRatesUiState.Success -> {
                    CurrencyContent(stateValue.value.rates)
                }
                is ExchangeRatesUiState.Failure -> {
                    Toast.makeText(context, "Please try again!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

