package com.example.hilttask.di

import com.example.hilttask.domain.GetUserNameUseCase
import com.example.hilttask.domain.SaveUserNameUseCase
import com.example.hilttask.domain.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(repository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(repository)
    }

    @Provides
    fun provideSaveUserNameUseCase(repository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(repository)
    }
}