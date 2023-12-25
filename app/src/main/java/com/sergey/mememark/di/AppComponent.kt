package com.sergey.mememark.di

import com.sergey.mememark.presenttation.Activity.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}