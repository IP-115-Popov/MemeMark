package com.sergey.mememark.di

import android.content.Context
import com.sergey.mememark.presenttation.Activity.MainActivity
import com.sergey.mememark.presenttation.Activity.SignInActivity
import com.sergey.mememark.presenttation.ViewModel.MainViewModelFactory
import com.sergey.mememark.presenttation.ViewModel.SingInViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(signInActivity: SignInActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}