package com.arnon.currencyconverter.core.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Currency(
    val symbol: String,
    val name: String,
) : Parcelable