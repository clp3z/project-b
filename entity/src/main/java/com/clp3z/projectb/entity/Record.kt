package com.clp3z.projectb.entity

import kotlinx.serialization.Serializable

@Serializable
data class Record(
    val id: Long = 0,
    val symbol: String,
    val price: Double,
    val timestamp: Long
)
