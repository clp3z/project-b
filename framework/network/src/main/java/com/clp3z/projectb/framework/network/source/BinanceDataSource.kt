package com.clp3z.projectb.framework.network.source

import arrow.core.Either
import com.clp3z.projectb.entity.Error
import com.clp3z.projectb.entity.Record

interface BinanceDataSource {

    suspend fun getBitcoinRecord(): Either<Error, Record>
}
