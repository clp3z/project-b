package com.clp3z.projectb.framework.network.source

import com.clp3z.projectb.common.time.TimeProvider
import com.clp3z.projectb.entity.Error
import com.clp3z.projectb.entity.Record
import com.clp3z.projectb.framework.network.RemoteRecord
import com.clp3z.projectb.framework.network.service.BinanceService
import com.clp3z.projectb.test.CoroutinesTestRule
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class BinanceDataSourceImplTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val mockkRule = MockKRule(this)

    @MockK
    private lateinit var binanceService: BinanceService

    @MockK
    private lateinit var timeProvider: TimeProvider

    private lateinit var dataSource: BinanceDataSource

    @Before
    fun setUp() {
        dataSource = BinanceDataSourceImpl(binanceService, timeProvider)
    }

    @Test
    fun `getBitcoinRecord maps service response to domain model when successful`() = runTest {
        // Given
        val bitcoinSymbol = "BTCUSDT"
        val timestamp = 123456789L
        val price = 50000.0

        val remoteRecord = RemoteRecord(
            symbol = bitcoinSymbol,
            price = price
        )

        val expectedRecord = Record(
            symbol = bitcoinSymbol,
            price = price,
            timestamp = timestamp
        )

        every { timeProvider.getTimestamp() } returns timestamp
        coEvery { binanceService.getCryptoCurrencyPrice(bitcoinSymbol) } returns remoteRecord

        // When
        val result = dataSource.getBitcoinRecord(bitcoinSymbol)

        // Then
        assertTrue(result.isRight())
        assertEquals(expectedRecord, result.getOrNull())
    }

    @Test
    fun `getBitcoinRecord returns Server error when HTTP exception occurs`() = runTest {
        // Given
        val bitcoinSymbol = "BTCUSDT"
        val errorCode = 500
        val errorMessage = "Internal Server Error"
        val response = mockk<Response<Any>>()
        every { response.code() } returns errorCode
        every { response.message() } returns errorMessage

        val httpException = HttpException(response)

        coEvery { binanceService.getCryptoCurrencyPrice(bitcoinSymbol) } throws httpException

        // When
        val result = dataSource.getBitcoinRecord(bitcoinSymbol)

        // Then
        assertTrue(result.isLeft())
        val error = result.leftOrNull()
        assertTrue(error is Error.Server)
        assertEquals(errorCode, (error as Error.Server).code)
        assertEquals(errorMessage, error.message)
    }

    @Test
    fun `getBitcoinRecord returns Unknown error when general exception occurs`() = runTest {
        // Given
        val bitcoinSymbol = "BTCUSDT"
        val errorMessage = "Unknown error"
        val exception = RuntimeException(errorMessage)

        coEvery { binanceService.getCryptoCurrencyPrice(bitcoinSymbol) } throws exception

        // When
        val result = dataSource.getBitcoinRecord(bitcoinSymbol)

        // Then
        assertTrue(result.isLeft())
        val error = result.leftOrNull()
        assertTrue(error is Error.Unknown)
        assertEquals(errorMessage, (error as Error.Unknown).message)
    }
}
