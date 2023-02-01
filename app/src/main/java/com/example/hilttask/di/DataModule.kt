package com.example.hilttask.di

import android.content.Context
import com.example.hilttask.data.UserRepositoryImpl
import com.example.hilttask.data.UserStorage
import com.example.hilttask.domain.UserRepository
import com.example.hilttask.data.SharedPrefUserStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }
}