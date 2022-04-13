package com.mirkamol.instagramclone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mirkamol.instagramclone.R
import com.mirkamol.instagramclone.manager.AuthHandler
import com.mirkamol.instagramclone.manager.AuthManager
import com.mirkamol.instagramclone.model.User
import com.mirkamol.instagramclone.utils.Extensions.toast
import java.lang.Exception

/*
*In SignUpActivity, user can signup using fullname ,email, password
 */
class SignUpActivity : BaseActivity() {
    val TAG = SignUpActivity::class.java.toString()
    lateinit var et_email: EditText
    lateinit var et_password: EditText
    lateinit var et_fullname: EditText
    lateinit var et_cpassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initViews()
    }

    private fun initViews() {
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        et_cpassword = findViewById(R.id.et_cpassword)
        et_fullname = findViewById(R.id.et_fullname)

        val b_signup = findViewById<Button>(R.id.b_signup)

        b_signup.setOnClickListener {
            val fullname = et_fullname.text.toString().trim()
            val email = et_email.text.toString().trim()
            val cpassword = et_cpassword.text.toString().trim()
            val password = et_password.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()){
                val user = User(fullname, email, password, "")
                firebaseSignUp(user)
            }

        }

        val tv_signup = findViewById<TextView>(R.id.tv_signup)
        tv_signup.setOnClickListener {
            finish()
        }

    }

    private fun firebaseSignUp(user:User){
        showLoading(this)
        AuthManager.signUp(user.email, user.password, object :AuthHandler{
            override fun onSuccess(uid: String) {
                user.uid = uid
                storeUserToDb()
                toast(getString(R.string.str_signup_success))
            }

            override fun onError(exception: Exception?) {
                dismissLoading()
                toast(getString(R.string.str_signup_failed))
            }

        })
    }

    private fun storeUserToDb() {

    }
}