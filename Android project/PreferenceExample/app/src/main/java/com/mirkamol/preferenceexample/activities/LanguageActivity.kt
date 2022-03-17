package com.mirkamol.preferenceexample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mirkamol.preferenceexample.MyApplication
import com.mirkamol.preferenceexample.R
import com.mirkamol.preferenceexample.manager.LocaleManager

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        initViews()
    }

    private fun initViews() {
        val bEnglish = findViewById<Button>(R.id.b_english)
        bEnglish.setOnClickListener {
            MyApplication.localManager!!.setNewLocale(this, LocaleManager.LANGUAGE_ENGLISH)
            finish()
        }
        val bKorean = findViewById<Button>(R.id.b_korean)
        bKorean.setOnClickListener {
            MyApplication.localManager!!.setNewLocale(this, LocaleManager.LANGUAGE_KOREAN)
            finish()
        }
        val bJapan = findViewById<Button>(R.id.b_japan)
        bJapan.setOnClickListener {
            MyApplication.localManager!!.setNewLocale(this, LocaleManager.LANGUAGE_JAPAN)
            finish()
        }
        val bUzbek = findViewById<Button>(R.id.b_uzbek)
        bUzbek.setOnClickListener {
            MyApplication.localManager!!.setNewLocale(this, LocaleManager.LANGUAGE_UZBEK)
            finish()
        }
    }
}