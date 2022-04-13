package com.mirkamol.simpleprojectforfirebase.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mirkamol.simpleprojectforfirebase.R
import com.mirkamol.simpleprojectforfirebase.managers.AuthHandler
import com.mirkamol.simpleprojectforfirebase.managers.AuthManager
import com.mirkamol.simpleprojectforfirebase.utils.Extensions.toast
import java.lang.Exception

class SignUpActivity : BaseActivity() {
    val TAG = SignUpActivity::class.java.toString()
    lateinit var et_fullname: EditText
    lateinit var et_password: EditText
    lateinit var et_email: EditText
    lateinit var et_cpassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initViews()
    }

    private fun initViews() {
         et_fullname = findViewById(R.id.et_fullname)
         et_email = findViewById(R.id.et_email)
         et_password = findViewById(R.id.et_password)
        et_cpassword = findViewById(R.id.et_confirm)
        val signUp = findViewById<Button>(R.id.btn_sign_up)

        signUp.setOnClickListener {
            val email = et_email.text.toString().trim()
            val password = et_password.text.toString().trim()

            firebaseSignUp(email, password)
        }

        val tv_signIn = findViewById<TextView>(R.id.tv_sign_in)

        tv_signIn.setOnClickListener {
           finish()
        }


    }

    private fun firebaseSignUp(email: String, password: String) {
        showLoading(this)
        AuthManager.signUp(email, password, object : AuthHandler {
            override fun onSuccess() {
                dismissLoading()
                toast("Signed up successfully")

                callMainActivity(context)
            }

            override fun onError(exception: Exception?) {
                dismissLoading()
                toast("Sign up failed")
            }

        })
    }
}