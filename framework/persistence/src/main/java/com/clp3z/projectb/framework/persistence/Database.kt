package com.clp3z.projectb.framework.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clp3z.projectb.framework.persistence.dao.BinanceDao
import com.clp3z.projectb.framework.persistence.model.LocalCurrencyCandle

@Database(
    entities = [LocalCurrencyCandle::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun binanceDao(): BinanceDao
}
