package com.mirkamol.simpleprojectforfirebase.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import com.mirkamol.simpleprojectforfirebase.R
import com.mirkamol.simpleprojectforfirebase.managers.AuthManager

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)


        initViews()
    }

    fun initViews(){
        countDownTimer()
    }

    fun countDownTimer() {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {

                if (AuthManager.isSignIn()){
                    callMainActivity(this@SplashActivity)
                }else{
                    callSignInActivity(this@SplashActivity)
                }


            }
        }.start()
    }



}