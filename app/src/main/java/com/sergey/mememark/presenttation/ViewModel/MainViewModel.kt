package com.sergey.mememark.presenttation.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergey.mememark.domain.usecase.SignUpUseCase
import com.sergey.mememark.domain.usecase.SingInUseCase

class MainViewModel(
    private val signUpUseCase: SignUpUseCase,
): ViewModel(){
    //private val resultLiveMutable = MutableLiveData<Int>()
    //val resultLive: LiveData<Int> = resultLiveMutable

    fun singUp(login:String, email:String, pass:String)
    {
        signUpUseCase.exectute(login, email, pass)
    }
}