package com.clp3z.projectb.framework.network.source

import arrow.core.Either
import com.clp3z.projectb.common.tryCall
import com.clp3z.projectb.entity.Error
import com.clp3z.projectb.entity.Record
import com.clp3z.projectb.framework.network.service.BinanceService
import com.clp3z.projectb.framework.network.toError
import com.clp3z.projectb.framework.network.toRecord
import javax.inject.Inject

class BinanceDataSourceImpl @Inject constructor(
    private val binanceService: BinanceService
) : BinanceDataSource {

    companion object {
        const val BITCOIN_SYMBOL = "BTCUSDT"
    }

    override suspend fun getBitcoinRecord(): Either<Error, Record> = tryCall(
        execute = {
            binanceService
                .getCryptoCurrencyPrice(BITCOIN_SYMBOL)
                .toRecord()
        },
        toError = {
            it.toError()
        }
    )
}
