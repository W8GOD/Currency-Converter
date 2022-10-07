package com.arnon.currencyconverter.ui.views

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arnon.currencyconverter.MainViewModel
import com.arnon.currencyconverter.ui.theme.CurrencyConverterTheme

@ExperimentalFoundationApi
@Composable
fun RootContent(
    context: Context, mainViewModel: MainViewModel
) {
    CurrencyConverterTheme {
        Scaffold(topBar = {
            TopAppBar(modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp),
                elevation = 0.dp,
                title = {},
                actions = {})
        }) { innerPadding ->
            BodyContent(
                context, Modifier.padding(innerPadding), mainViewModel
            )
        }
    }
}