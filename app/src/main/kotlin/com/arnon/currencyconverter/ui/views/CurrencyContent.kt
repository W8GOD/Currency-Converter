package com.arnon.currencyconverter.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arnon.currencyconverter.core.model.ExchangeRate

@ExperimentalFoundationApi
@Composable
fun CurrencyContent(exchangeRate: List<ExchangeRate>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = Modifier.padding(0.dp, 16.dp)
    ) {
        itemsIndexed(items = exchangeRate) { _, item ->
            CurrencyListItem(item)
        }
    }
}