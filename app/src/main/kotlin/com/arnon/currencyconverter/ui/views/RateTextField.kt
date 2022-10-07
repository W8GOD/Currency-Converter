package com.arnon.currencyconverter.ui.views

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arnon.currencyconverter.ui.theme.Blue
import com.arnon.currencyconverter.ui.theme.DarkestGrey
import com.arnon.currencyconverter.ui.theme.LightGrey
import com.arnon.currencyconverter.ui.theme.Transparent

@Composable
fun RateTextField(
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
        textStyle = LocalTextStyle.current.copy(
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        ),
        singleLine = true,
        shape = RoundedCornerShape(32.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = DarkestGrey,
            backgroundColor = LightGrey,
            disabledTextColor = DarkestGrey,
            focusedIndicatorColor = Transparent,
            unfocusedIndicatorColor = Transparent,
            disabledIndicatorColor = Transparent,
            cursorColor = Blue
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}