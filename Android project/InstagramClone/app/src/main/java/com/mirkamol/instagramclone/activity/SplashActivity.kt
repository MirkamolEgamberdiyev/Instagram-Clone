package com.mirkamol.instagramclone.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Window
import android.view.WindowManager
import com.mirkamol.instagramclone.R
import com.mirkamol.instagramclone.manager.AuthManager

/*
*In SplashActivity, user can visit to SignInActivity or MainActivity
 */
@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    val TAG = SplashActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        initViews()

    }

    private fun initViews() {
        countDownTimer()
    }

    private fun countDownTimer() {
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