package com.sergey.mememark.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.sergey.mememark.data.repository.UserRepositoryImpl
import com.sergey.mememark.data.storage.IUserStorage
import com.sergey.mememark.data.storage.sharedrefs.SharedPrefUserStorage
import com.sergey.mememark.domain.repository.IUserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule() {
    @Provides
    fun provideIUserStorage(context: Context): IUserStorage
    {
        return SharedPrefUserStorage(context,null)
    }
    @Provides
    fun provideIUserRepository(userStorage: IUserStorage): IUserRepository
    {
        return UserRepositoryImpl(userStorage)
    }
}