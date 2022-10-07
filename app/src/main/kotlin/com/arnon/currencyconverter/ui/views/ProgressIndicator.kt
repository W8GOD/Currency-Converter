package com.arnon.currencyconverter.ui.views

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arnon.currencyconverter.ui.theme.Blue

@Composable
fun ProgressIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.size(size = 32.dp),
        color = Blue,
        strokeWidth = 2.dp
    )
}