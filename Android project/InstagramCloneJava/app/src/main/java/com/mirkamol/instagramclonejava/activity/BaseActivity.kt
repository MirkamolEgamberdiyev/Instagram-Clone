package com.mirkamol.instagramclonejava.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mirkamol.instagramclonejava.R

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}