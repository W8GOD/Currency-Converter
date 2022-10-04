package com.arnon.currencyconverter.core.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LatestExchangeRatesResponse(
    @SerializedName("base")
    val base: String = "",
    @SerializedName("timestamp")
    val timestamp: Long = 0,
    @SerializedName("rates")
    val rates: List<Map<String, Double>> = emptyList()
) : Parcelable