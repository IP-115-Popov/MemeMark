package com.sergey.mememark.di

import com.sergey.mememark.domain.repository.IUserRepository
import com.sergey.mememark.domain.usecase.SignUpUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideSignUpUseCase(userRepository: IUserRepository) : SignUpUseCase {
        return SignUpUseCase(userRepository)
    }

}