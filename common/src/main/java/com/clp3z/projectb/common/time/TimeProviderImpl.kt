package com.clp3z.projectb.common.time

internal class TimeProviderImpl : TimeProvider {

    override fun getTimestamp(): Long = System.currentTimeMillis()
}
