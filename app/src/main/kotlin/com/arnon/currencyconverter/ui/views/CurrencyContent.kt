package com.arnon.currencyconverter.ui.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.arnon.currencyconverter.core.model.ExchangeRate

@Composable
fun CurrencyContent(exchangeRate: List<ExchangeRate>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(exchangeRate) { item ->
            CurrencyListItem(item)
        }
    }
}