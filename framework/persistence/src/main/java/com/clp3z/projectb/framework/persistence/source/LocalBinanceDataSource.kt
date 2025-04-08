package com.clp3z.projectb.framework.persistence.source

import com.clp3z.projectb.entity.CurrencyCandle
import kotlinx.coroutines.flow.Flow

interface LocalBinanceDataSource {

    suspend fun insertCurrencyCandles(candles: List<CurrencyCandle>)

    fun getCurrencyCandles(
        currency: String,
        startOfDay: Long,
        endOfDay: Long
    ): Flow<List<CurrencyCandle>>

    fun getHighestPriceCandle(
        currency: String,
        startOfDay: Long,
        endOfDay: Long
    ): Flow<CurrencyCandle>

    fun getLowestPriceCandle(
        currency: String,
        startOfDay: Long,
        endOfDay: Long
    ): Flow<CurrencyCandle>

    fun getAveragePrice(currency: String, startOfDay: Long, endOfDay: Long): Flow<Double>
}