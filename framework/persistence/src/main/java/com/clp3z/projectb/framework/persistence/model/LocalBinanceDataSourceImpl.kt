package com.clp3z.projectb.framework.persistence.model

import com.clp3z.projectb.entity.CurrencyCandle
import com.clp3z.projectb.framework.persistence.dao.BinanceDao
import com.clp3z.projectb.framework.persistence.source.LocalBinanceDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import toCurrencyCandle
import toCurrencyCandles
import toLocalCurrencyCandle
import javax.inject.Inject

internal class LocalBinanceDataSourceImpl @Inject constructor(
    private val binanceDao: BinanceDao
): LocalBinanceDataSource {

    override suspend fun insertCurrencyCandles(candles: List<CurrencyCandle>) =
        binanceDao.insertCurrencyCandles(candles.map { it.toLocalCurrencyCandle() })

    override fun getCurrencyCandles(currency: String, startOfDay: Long, endOfDay: Long): Flow<List<CurrencyCandle>> =
        binanceDao
            .getCurrencyCandles(currency, startOfDay, endOfDay)
            .map { it.toCurrencyCandles() }

    override fun getHighestPriceCandle(currency: String, startOfDay: Long, endOfDay: Long): Flow<CurrencyCandle> =
        binanceDao
            .getHighestPriceCandle(currency, startOfDay, endOfDay)
            .map { it.toCurrencyCandle() }

    override fun getLowestPriceCandle(currency: String, startOfDay: Long, endOfDay: Long): Flow<CurrencyCandle> =
        binanceDao
            .getLowestPriceCandle(currency, startOfDay, endOfDay)
            .map { it.toCurrencyCandle() }

    override fun getAveragePrice(currency: String, startOfDay: Long, endOfDay: Long): Flow<Double> =
        binanceDao.getAveragePrice(currency, startOfDay, endOfDay)
}
