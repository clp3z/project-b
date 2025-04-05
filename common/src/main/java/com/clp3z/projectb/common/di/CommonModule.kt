package com.clp3z.projectb.common.di

import com.clp3z.projectb.common.time.TimeProvider
import com.clp3z.projectb.common.time.TimeProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Provides
    @Singleton
    fun provideTimeProvider(): TimeProvider = TimeProviderImpl()
}
