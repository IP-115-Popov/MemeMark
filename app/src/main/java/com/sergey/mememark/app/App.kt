package com.sergey.mememark.app

import android.app.Application
import android.content.Context
import com.sergey.mememark.di.AppComponent
import com.sergey.mememark.di.AppModule
import com.sergey.mememark.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()


        appComponent = DaggerAppComponent.create()
    }
}
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }