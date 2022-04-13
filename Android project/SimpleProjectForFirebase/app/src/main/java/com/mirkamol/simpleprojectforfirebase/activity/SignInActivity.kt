package com.mirkamol.simpleprojectforfirebase.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mirkamol.simpleprojectforfirebase.R
import com.mirkamol.simpleprojectforfirebase.managers.AuthHandler
import com.mirkamol.simpleprojectforfirebase.managers.AuthManager
import com.mirkamol.simpleprojectforfirebase.utils.Extensions.toast
import java.lang.Exception

class SignInActivity : BaseActivity() {
    val TAG = SignInActivity::class.java.toString()
    lateinit var et_email: EditText
    lateinit var et_password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initViews()

    }

    private fun initViews() {
         et_email = findViewById(R.id.email)
         et_password = findViewById(R.id.password)
        val btn_sign_in = findViewById<Button>(R.id.btn_sign_in)

        btn_sign_in.setOnClickListener {
            val email = et_email.text.toString().trim()
            val password = et_password.text.toString().trim()
            firebaseSignIn(email, password)
        }

        val tv_sign_up = findViewById<TextView>(R.id.tv_sign_up)
        tv_sign_up.setOnClickListener {
           callSignUpActivity()
        }



    }

    fun callSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun firebaseSignIn(email:String, password:String){
        showLoading(this)
        AuthManager.signIn(email, password, object:AuthHandler{
            override fun onSuccess() {
                dismissLoading()
                toast("Signed in Successfully")
                callMainActivity(context)

            }

            override fun onError(exception: Exception?) {
                dismissLoading()
                toast("Sign in failed ${exception.toString()}")
            }

        })
    }


}