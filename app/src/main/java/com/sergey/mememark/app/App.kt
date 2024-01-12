package com.sergey.mememark.app

import android.app.Application
import android.content.Context
import com.sergey.mememark.di.AppComponent
import com.sergey.mememark.di.AppModule
import com.sergey.mememark.di.DaggerAppComponent
import com.sergey.mememark.di.DataModule

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()


        appComponent = DaggerAppComponent.builder()
            .context(context = this)
            .build()
    }
}
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }