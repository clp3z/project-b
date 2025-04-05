package com.clp3z.projectb.framework.network

import com.clp3z.projectb.entity.Record

fun RemoteRecord.toRecord(): Record = Record(
    symbol = symbol,
    price = price,
    timestamp = System.currentTimeMillis()
)
