package com.sergey.mememark.di

import android.content.Context
import com.sergey.mememark.presenttation.Activity.MainActivity
import com.sergey.mememark.presenttation.ViewModel.MainViewModelFactory
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}