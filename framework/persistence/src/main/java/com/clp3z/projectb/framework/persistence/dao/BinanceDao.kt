package com.clp3z.projectb.framework.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.clp3z.projectb.framework.persistence.model.LocalCurrencyCandle
import kotlinx.coroutines.flow.Flow

@Dao
interface BinanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencyCandles(candles: List<LocalCurrencyCandle>)

    @Query("SELECT * FROM LocalCurrencyCandle WHERE openingTime >= :startOfDay AND openingTime < :endOfDay ORDER BY openingTime ASC")
    fun getCurrencyCandles(startOfDay: Long, endOfDay: Long): Flow<List<LocalCurrencyCandle>>

    @Query("SELECT * FROM LocalCurrencyCandle WHERE openingTime >= :startOfDay AND openingTime < :endOfDay ORDER BY highPrice DESC LIMIT 1")
    fun getHighestPriceCandle(startOfDay: Long, endOfDay: Long): Flow<LocalCurrencyCandle>

    @Query("SELECT * FROM LocalCurrencyCandle WHERE openingTime >= :startOfDay AND openingTime < :endOfDay ORDER BY lowPrice ASC LIMIT 1")
    fun getLowestPriceCandle(startOfDay: Long, endOfDay: Long): Flow<LocalCurrencyCandle>

    @Query("SELECT AVG(closePrice) FROM LocalCurrencyCandle WHERE openingTime >= :startOfDay AND openingTime < :endOfDay")
    fun getAveragePrice(startOfDay: Long, endOfDay: Long): Flow<Double>
}
