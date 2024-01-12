package com.sergey.mememark.presenttation.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergey.mememark.domain.usecase.MoveSignUpToIn
import com.sergey.mememark.domain.usecase.SignUpUseCase

class MainViewModel(
    private val signUpUseCase: SignUpUseCase,
    private val moveSignUpToIn: MoveSignUpToIn,
): ViewModel(){
    private val resultLiveMutable = MutableLiveData<Int>()
    val resultLive: LiveData<Int> = resultLiveMutable

    fun singUp(login:String, email:String, pass:String)
    {
        signUpUseCase.exectute()
    }
    fun SignUpToIn()
    {
        moveSignUpToIn.exectute()
    }
}