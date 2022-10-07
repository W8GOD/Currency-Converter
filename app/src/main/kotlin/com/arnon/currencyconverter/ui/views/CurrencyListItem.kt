package com.arnon.currencyconverter.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arnon.currencyconverter.core.model.ExchangeRate
import com.arnon.currencyconverter.ui.theme.Blue
import com.arnon.currencyconverter.ui.theme.DarkestGrey
import com.arnon.currencyconverter.ui.theme.White

@Composable
fun CurrencyListItem(item: ExchangeRate) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = item.symbol, style = typography.h6, color = Blue)
                Text(
                    text = String.format("%.4f", item.value),
                    style = typography.caption,
                    color = DarkestGrey,
                    maxLines = 1
                )
            }
        }
    }
}