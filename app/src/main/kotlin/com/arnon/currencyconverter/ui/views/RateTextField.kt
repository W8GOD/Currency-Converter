package com.arnon.currencyconverter.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun RateTextField(
    modifier: Modifier,
    readOnly: Boolean,
    value: String,
    enabled: Boolean,
    onBaseAmountChanged: (newBaseAmount: String) -> Unit
) {
    OutlinedTextField(
        value = value,
        readOnly = readOnly,
        enabled = enabled,
        onValueChange = { newValue ->
            onBaseAmountChanged(newValue)
        },
        modifier = modifier.fillMaxWidth(),
        textStyle = LocalTextStyle.current.copy(
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        ),
        singleLine = true,
        shape = RoundedCornerShape(6.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.DarkGray,
            backgroundColor = MaterialTheme.colors.secondary,
            disabledTextColor = Color.DarkGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colors.onPrimary
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}