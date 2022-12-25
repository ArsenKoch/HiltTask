package com.example.hilttask.di

import android.content.Context
import com.example.hilttask.data.UserRepositoryImpl
import com.example.hilttask.data.UserStorage
import com.example.hilttask.domain.UserRepository
import com.example.mvvmexample.data.SharedPrefUserStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
class DataModule() {

    @Provides
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }
}