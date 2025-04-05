package com.clp3z.projectb.framework.network.service

import com.clp3z.projectb.framework.network.RemoteRecord
import retrofit2.http.GET
import retrofit2.http.Query

interface BinanceService {

    @GET("api/v3/ticker/price")
    suspend fun getCryptoCurrencyPrice(@Query("symbol") symbol: String): RemoteRecord
}
