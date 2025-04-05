package com.clp3z.projectb.framework.network

import kotlinx.serialization.Serializable

@Serializable
data class RemoteRecord(
    val symbol: String,
    val price: Double
)
