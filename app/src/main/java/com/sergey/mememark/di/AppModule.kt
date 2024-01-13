package com.sergey.mememark.di

import com.sergey.mememark.domain.usecase.SignUpUseCase
import com.sergey.mememark.domain.usecase.SingInUseCase
import com.sergey.mememark.presenttation.ViewModel.MainViewModelFactory
import com.sergey.mememark.presenttation.ViewModel.SingInViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule() {
    @Provides
    fun provideMainViewModelFactory(signUpUseCase: SignUpUseCase) : MainViewModelFactory {
        return MainViewModelFactory(signUpUseCase)
    }
    @Provides
    fun provideSingInViewModelFactory(singInUseCase: SingInUseCase): SingInViewModelFactory
    {
        return SingInViewModelFactory(singInUseCase)
    }
}