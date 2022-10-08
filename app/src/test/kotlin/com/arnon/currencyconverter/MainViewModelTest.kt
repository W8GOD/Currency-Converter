package com.arnon.currencyconverter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.arnon.currencyconverter.core.CoreNetworkingProvider
import com.arnon.currencyconverter.core.database.exchangerate.*
import com.arnon.currencyconverter.core.model.ExchangeRate
import com.arnon.currencyconverter.core.model.response.LatestExchangeRateResponse
import com.arnon.currencyconverter.core.repository.GetCurrenciesRepository
import com.arnon.currencyconverter.core.repository.GetLatestExchangeRatesRepository
import com.arnon.currencyconverter.core.service.ApiExchangeRatesService
import com.arnon.currencyconverter.core.service.ApiExchangeRatesServiceHelperImpl
import com.arnon.currencyconverter.extension.MainCoroutineRule
import com.arnon.currencyconverter.model.MainCurrency
import com.arnon.currencyconverter.ui.CurrenciesUiState
import com.arnon.currencyconverter.ui.ExchangeRatesUiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    private lateinit var apiExchangeRatesService: ApiExchangeRatesService

    @Mock
    private lateinit var exchangeRatesDao: ExchangeRatesDao

    private lateinit var remoteDataSource: ApiExchangeRatesServiceHelperImpl

    private lateinit var getExchangeRatesRepository: GetLatestExchangeRatesRepository
    private lateinit var getCurrenciesRepository: GetCurrenciesRepository

    private lateinit var coreNetworkingProvider: CoreNetworkingProvider

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() = runBlocking {
        remoteDataSource = ApiExchangeRatesServiceHelperImpl(apiExchangeRatesService)

        getExchangeRatesRepository =
            GetLatestExchangeRatesRepository(remoteDataSource, exchangeRatesDao)
        getCurrenciesRepository = GetCurrenciesRepository(remoteDataSource, exchangeRatesDao)

        coreNetworkingProvider = CoreNetworkingProvider()

        coreNetworkingProvider.getExchangeRatesRepository = getExchangeRatesRepository
        coreNetworkingProvider.getCurrenciesRepository = getCurrenciesRepository

        viewModel = MainViewModel(coreNetworkingProvider)
    }

    @Test
    fun giveCurrencyDefault_whenCalled_thenReturnDefaultValue() {
        val currencyDefault = "USD"
        assertThat(viewModel.currencyDefault, `is`(currencyDefault))
    }

    @Test
    fun giveCurrencyListDefault_whenCalled_thenReturnDefaultValue() {
        val currencyListDefault = listOf(MainCurrency("USD", true))
        assertThat(viewModel.currencyListDefault, `is`(currencyListDefault))
    }

    @Test
    fun giveExchangeRatesUiState_whenGetResult_thenReturnSuccess() = runBlocking {
        val ratesDB = listOf(RateDBItem(currency = "JPY", value = 145.123))
        val rates = listOf(ExchangeRate(symbol = "JPY", value = 145.123))
        val base = "USD"
        val timestamp = 99999L
        val resultDB = flow {
            emit(ExchangeRatesDB(base = base, timestamp = timestamp, rates = ratesDB))
        }

        `when`(exchangeRatesDao.getLatestExchangeRates()).thenReturn(resultDB)
        `when`(apiExchangeRatesService.getLatestExchangeRates())
            .thenReturn(LatestExchangeRateResponse())

        viewModel.refreshExchangeRates()

        viewModel.exchangeRatesUiState.value.let {
            assertThat(it, `is`(ExchangeRatesUiState.Loading))
        }

        delay(3000)

        viewModel.exchangeRatesUiState.value.let {
            assertThat(it, `is`(CoreMatchers.notNullValue()))
            if (it is ExchangeRatesUiState.Success) {
                assertTrue(it.value.rates == rates)
                assertTrue(it.value.base == base)
                assertTrue(it.value.timestamp == timestamp)
            } else {
                fail("Wrong type $it")
            }
        }
    }

    @Test
    fun giveCurrenciesUiState_whenGetResult_thenReturnSuccess() = runBlocking {
        val symbol = "JPY"
        val name = "Japanese Yen"
        val resultDB = flow {
            emit(CurrenciesDB(1, listOf(CurrenciesDBItem(symbol, name))))
        }

        `when`(exchangeRatesDao.getCurrencies()).thenReturn(resultDB)
        `when`(apiExchangeRatesService.getCurrencies()).thenReturn(mapOf())

        viewModel.fetchCurrencies()

        viewModel.currenciesUiState.value.let {
            assertThat(it, `is`(CurrenciesUiState.Loading))
        }

        delay(3000)

        viewModel.currenciesUiState.value.let {
            assertThat(it, `is`(CoreMatchers.notNullValue()))
            if (it is CurrenciesUiState.Success) {
                assertTrue(it.value.first().symbol == symbol)
            } else {
                fail("Wrong type $it")
            }
        }
    }
}