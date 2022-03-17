package com.mirkamol.sharedpreference.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mirkamol.sharedpreference.R
import com.mirkamol.sharedpreference.SharedPref

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var handler = Handler()
        handler.postDelayed({
            if (SharedPref(this).isSaved == true) {
                Intent(this, MainActivity::class.java).also {
                    startActivity(it)
                }
            } else {
                Intent(this, HomeActivity::class.java).also {
                    startActivity(it)
                }
            }


        }, 2000)


    }
}