package com.sergey.mememark.data.repository

import com.sergey.mememark.data.storage.IUserStorage
import com.sergey.mememark.data.storage.models.UserForStorage
import com.sergey.mememark.domain.models.User
import com.sergey.mememark.domain.repository.IUserRepository

class UserRepositoryImpl(private val userStorage: IUserStorage): IUserRepository {
    override fun saveUser(user: User) {
        userStorage.save(UserForStorage(
            user.login,
            user.email,
            user.pass
        ))
    }

    override fun userIsInRepository(login: String, pass: String): Boolean {
       return userStorage.get(login,pass)
    }
}