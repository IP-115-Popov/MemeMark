package com.sergey.mememark.domain.usecase

import com.sergey.mememark.domain.models.User
import com.sergey.mememark.domain.repository.IUserRepository

class SignUpUseCase(private val userRepository: IUserRepository) {
    fun exectute(login:String, email:String, pass:String)
    {
        userRepository.saveUser(User(login, email, pass))
    }
}