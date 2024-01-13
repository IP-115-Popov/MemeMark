package com.sergey.mememark.presenttation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sergey.mememark.domain.usecase.SignUpUseCase
import com.sergey.mememark.domain.usecase.SingInUseCase

class SingInViewModelFactory(
    private val singInUseCase: SingInUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SingInViewModel(
            singInUseCase = singInUseCase
        ) as T
    }
}