package com.arnon.currencyconverter.core.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LatestExchangeRateResponse(
    @Json(name = "base")
    val base: String = "",
    @Json(name = "timestamp")
    val timestamp: Long = 0,
    @Json(name = "rates")
    val rates: Map<String, Double> = mapOf()
) : Parcelable