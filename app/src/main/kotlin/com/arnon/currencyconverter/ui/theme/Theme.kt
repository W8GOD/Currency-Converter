package com.arnon.currencyconverter.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = White,
    onPrimary = Blue,
    primaryVariant = Green,
    secondary = LightGrey,
    secondaryVariant = DarkGrey,
    onSecondary = DarkerGrey,
    onSurface = LightBlue
)

private val LightColorPalette = lightColors(
    primary = White,
    onPrimary = Blue,
    primaryVariant = Green,
    secondary = LightGrey,
    secondaryVariant = DarkGrey,
    onSecondary = DarkerGrey,
    onSurface = LightBlue

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CurrencyConverterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        val colors = if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}