package com.example.hilttask.domain

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        return userRepository.saveName(param)
    }
}