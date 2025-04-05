package com.clp3z.projectb.common.time

class TimeProviderImpl : TimeProvider {

    override fun getTimestamp(): Long = System.currentTimeMillis()
}
