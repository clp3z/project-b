package com.clp3z.projectb.framework.network

import com.clp3z.projectb.entity.Error
import retrofit2.HttpException

fun Throwable.toError(): Error = when (this) {
    is HttpException -> Error.Server(code(), message() ?: stackTraceToString())
    else -> Error.Unknown(message ?: stackTraceToString())
}
