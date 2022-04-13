package com.mirkamol.instagramclonejava.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;

import com.mirkamol.instagramclonejava.R;
/*
 *In SplashActivity, user can visit to SignInActivity or MainActivity
 */
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initViews();
    }

    private void initViews() {
        countDownTimer();
    }

    private void countDownTimer() {
        new CountDownTimer(2000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                callSignInActivity();
            }
        }.start();
    }

    private void callSignInActivity() {

        Intent intent =new  Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }
}