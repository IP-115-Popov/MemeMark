package com.sergey.mememark.di

import com.sergey.mememark.domain.usecase.MoveSignUpToIn
import com.sergey.mememark.domain.usecase.SignUpUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideSignUpUseCase() : SignUpUseCase {
        return SignUpUseCase()
    }
    @Provides
    fun provideMoveSignUpToIn(): MoveSignUpToIn {
        return MoveSignUpToIn()
    }
}