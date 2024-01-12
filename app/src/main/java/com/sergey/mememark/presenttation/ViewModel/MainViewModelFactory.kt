package com.sergey.mememark.presenttation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sergey.mememark.domain.usecase.MoveSignUpToIn
import com.sergey.mememark.domain.usecase.SignUpUseCase


class MainViewModelFactory(
    private val signUpUseCase: SignUpUseCase,
    private val moveSignUpToIn: MoveSignUpToIn,
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            signUpUseCase = signUpUseCase,
            moveSignUpToIn = moveSignUpToIn
        ) as T
    }
}