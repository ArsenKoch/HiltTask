package com.example.hilttask.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hilttask.data.UserRepositoryImpl
import com.example.mvvmexample.data.SharedPrefUserStorage
import com.example.hilttask.domain.GetUserNameUseCase
import com.example.hilttask.domain.SaveUserNameUseCase

class MainViewModelFactory(context: Context) :
    ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            SharedPrefUserStorage(context = context)
        )
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}