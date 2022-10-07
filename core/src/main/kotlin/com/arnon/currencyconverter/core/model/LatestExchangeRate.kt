package com.arnon.currencyconverter.core.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LatestExchangeRate(
    val base: String = "",
    val timestamp: Long = 0,
    val rates: List<ExchangeRate> = emptyList()
) : Parcelable