package com.clp3z.projectb.framework.network.source

import arrow.core.Either
import com.clp3z.projectb.common.time.TimeProvider
import com.clp3z.projectb.common.tryCall
import com.clp3z.projectb.entity.Error
import com.clp3z.projectb.entity.Record
import com.clp3z.projectb.framework.network.service.BinanceService
import com.clp3z.projectb.framework.network.toError
import com.clp3z.projectb.framework.network.toRecord
import javax.inject.Inject

internal class BinanceDataSourceImpl @Inject constructor(
    private val binanceService: BinanceService,
    private val timeProvider: TimeProvider
) : BinanceDataSource {

    override suspend fun getBitcoinRecord(bitcoinSymbol: String): Either<Error, Record> =
        tryCall(
            execute = {
                binanceService
                    .getCryptoCurrencyPrice(bitcoinSymbol)
                    .toRecord(timeProvider.getTimestamp())
            },
            toError = {
                it.toError()
            }
        )
}
