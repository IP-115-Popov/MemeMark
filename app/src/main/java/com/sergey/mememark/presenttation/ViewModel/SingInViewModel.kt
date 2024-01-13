package com.sergey.mememark.presenttation.ViewModel

import androidx.lifecycle.ViewModel
import com.sergey.mememark.domain.usecase.SingInUseCase

class SingInViewModel(
    private val singInUseCase: SingInUseCase
): ViewModel(){
    fun SignIn(login:String, pass:String):Boolean
    {
        return singInUseCase.exectute(login,pass)
    }
}