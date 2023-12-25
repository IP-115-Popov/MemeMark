package com.sergey.mememark.presenttation.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sergey.mememark.R
import com.sergey.mememark.databinding.ActivityMainBinding
import com.sergey.mememark.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private var _binding: ActivitySignInBinding? = null
    private val binding: ActivitySignInBinding
        get() = _binding ?: throw IllegalStateException("Binding for SingInMain must not be null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}