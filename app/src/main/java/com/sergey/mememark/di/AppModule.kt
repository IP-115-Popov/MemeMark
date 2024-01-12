package com.sergey.mememark.di

import com.sergey.mememark.domain.usecase.SignUpUseCase
import com.sergey.mememark.presenttation.ViewModel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule() {
    @Provides
    fun provideMainViewModelFactory(signUpUseCase: SignUpUseCase) : MainViewModelFactory {
        return MainViewModelFactory(signUpUseCase)
    }
}