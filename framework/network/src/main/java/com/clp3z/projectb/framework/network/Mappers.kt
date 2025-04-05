package com.clp3z.projectb.framework.network

import com.clp3z.projectb.entity.Record

fun RemoteRecord.toRecord(timestamp: Long): Record = Record(
    symbol = symbol,
    price = price,
    timestamp = timestamp
)
