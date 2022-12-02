package com.example.beelineproject.di

import android.app.Application
import androidx.room.Room
import com.example.beelineproject.data.storage.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Provides
    fun provideUserDao(appDatabase: AppDatabase) = appDatabase.userDao()

    @Provides
    fun provideAlbumsDao(appDatabase: AppDatabase) = appDatabase.albumsDao()

    @Provides
    fun providePhotosDao(appDatabase: AppDatabase) = appDatabase.photosDao()

    @Provides
    @Singleton
    fun provideAppDatabase(context: Application) = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
}