package com.example.hilttask.data

interface UserStorage {
    fun save(user: User): Boolean

    fun get(): User
}