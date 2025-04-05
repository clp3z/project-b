package com.clp3z.projectb.entity

sealed interface Error {
    class Server(val code: Int, val message: String) : Error
    class Unknown(val message: String) : Error
}

fun Error.toErrorMessage(): String = when (this) {
    is Error.Server -> "Network error (code: $code): $message"
    is Error.Unknown -> "Unknown error: $message"
}
