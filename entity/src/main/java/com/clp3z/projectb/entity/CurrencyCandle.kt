package com.clp3z.projectb.entity

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyCandle(
    val id: Long,
    val openingTime: Long,
    val openPrice: Double,
    val closeTime: Long,
    val closePrice: Double,
    val highPrice: Double,
    val lowPrice: Double,
    val currency: String
)
