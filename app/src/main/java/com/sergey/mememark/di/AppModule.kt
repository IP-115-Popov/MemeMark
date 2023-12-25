package com.sergey.mememark.di

import com.sergey.mememark.presenttation.ViewModel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule() {
    @Provides
    fun provideMainViewModelFactory() : MainViewModelFactory {
        return MainViewModelFactory()
    }
}