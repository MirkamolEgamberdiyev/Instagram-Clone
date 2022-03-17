package com.mirkamol.preferenceexample.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mirkamol.preferenceexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter = findViewById<Button>(R.id.btn_enter)

        btnEnter.setOnClickListener {
            startActivity(Intent(this, LanguageActivity::class.java))
        }
    }
}