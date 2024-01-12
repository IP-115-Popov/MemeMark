package com.sergey.mememark.domain.repository

import com.sergey.mememark.domain.models.User

interface IUserRepository {
    fun saveUser(user:User)
}