package com.sergey.mememark.presenttation.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.sergey.mememark.R
import com.sergey.mememark.app.App
import com.sergey.mememark.app.appComponent
import com.sergey.mememark.databinding.ActivityMainBinding
import com.sergey.mememark.presenttation.ViewModel.MainViewModel
import com.sergey.mememark.presenttation.ViewModel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityMain must not be null")
    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private  lateinit var  vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appComponent.inject(this)
        vm = ViewModelProvider(this,vmFactory)
            .get(MainViewModel::class.java)

        val bthSingUp = binding.buttonReg
        val tvUserLogin = binding.userLogin
        val tvUserEmail = binding.userEmail
        val tvUserPass = binding.userPass
        val tvRegToLink = binding.regToLink
        bthSingUp.setOnClickListener {
            if (tvUserLogin.text.isEmpty() || tvUserEmail.text.isEmpty() || tvUserPass.text.isEmpty())
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                vm.singUp(
                    tvUserLogin.text.toString(),
                    tvUserEmail.text.toString(),
                    tvUserPass.text.toString()
                )
                Toast.makeText(this, "пользователь $tvUserLogin авторизован", Toast.LENGTH_LONG)
                    .show()
            }
        }
        tvRegToLink.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}