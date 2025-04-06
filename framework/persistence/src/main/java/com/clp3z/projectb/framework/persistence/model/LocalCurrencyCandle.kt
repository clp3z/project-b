package com.clp3z.projectb.framework.persistence.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalCurrencyCandle(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val openingTime: Long,
    val openPrice: Double,
    val closeTime: Long,
    val closePrice: Double,
    val highPrice: Double,
    val lowPrice: Double
)
