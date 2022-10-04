package com.arnon.currencyconverter.core

import com.arnon.currencyconverter.core.repository.GetExchangeRatesRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class CoreNetworkingProvider @Inject constructor() {
    @Inject
    lateinit var repository: GetExchangeRatesRepository
}