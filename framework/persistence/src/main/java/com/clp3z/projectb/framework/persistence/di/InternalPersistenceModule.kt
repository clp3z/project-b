package com.clp3z.projectb.framework.persistence.di

import android.app.Application

import androidx.room.Room
import com.clp3z.projectb.framework.persistence.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InternalPersistenceModule {

    private const val DATABASE_NAME = "project-b-database"

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): Database =
        Room.databaseBuilder(
            context = application,
            klass = Database::class.java,
            name = DATABASE_NAME,
        ).build()
}
