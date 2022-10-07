package com.arnon.currencyconverter.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainCurrency(
    val symbol: String,
    val isActive: Boolean
) : Parcelable