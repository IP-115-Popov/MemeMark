package com.sergey.mememark.domain.usecase

import com.sergey.mememark.domain.repository.IUserRepository

class SingInUseCase(private val userRepository: IUserRepository) {
    fun exectute(login:String, pass:String) :Boolean
    {
        return userRepository.userIsInRepository(login, pass)
    }
}