package com.sergey.mememark.presenttation.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.sergey.mememark.app.appComponent
import com.sergey.mememark.databinding.ActivitySignInBinding
import com.sergey.mememark.presenttation.ViewModel.SingInViewModel
import com.sergey.mememark.presenttation.ViewModel.SingInViewModelFactory
import javax.inject.Inject

class SignInActivity : AppCompatActivity() {
    private var _binding: ActivitySignInBinding? = null
    private val binding: ActivitySignInBinding
        get() = _binding ?: throw IllegalStateException("Binding for SingInMain must not be null")
    @Inject
    lateinit var vmFactory: SingInViewModelFactory
    private  lateinit var  vm: SingInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appComponent.inject(this)
        vm = ViewModelProvider(this,vmFactory)
            .get(SingInViewModel::class.java)

        val tvUserLogin = binding.userLoginAuth
        val tvUserPass = binding.userPassAuth
        val dthSingIn = binding.buttonAuth
        val tvSingInToUp = binding.linkToReg
        tvSingInToUp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        dthSingIn.setOnClickListener{
            val login = tvUserLogin.text.toString().trim()
            val pass = tvUserPass.text.toString().trim()
            if (login.isEmpty() || pass.isEmpty())
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else
            {
                val isAuth = vm.SignIn(login,pass)
                if (isAuth)
                {
                    Toast.makeText(this, "пользователь $login авторизован", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "пользователь не $login авторизован", Toast.LENGTH_LONG).show()

                tvUserLogin.text.clear()
                tvUserPass.text.clear()

            }
        }
    }
}