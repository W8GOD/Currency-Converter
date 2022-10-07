package com.arnon.currencyconverter.core.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ExchangeRate(
    val symbol: String = "",
    val value: Double = 0.0
) : Parcelable