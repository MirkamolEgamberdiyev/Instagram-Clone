package com.mirkamol.androidlocalisation.utils

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mirkamol.androidlocalisation.MyApplication
import com.mirkamol.androidlocalisation.R
import com.mirkamol.androidlocalisation.manager.LocaleManager
import java.util.*

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.language_layout)

        initViews()

        val one = resources.getQuantityString(R.plurals.my_cats, 1, 1)
        val few = resources.getQuantityString(R.plurals.my_cats, 2, 3)
        val many = resources.getQuantityString(R.plurals.my_cats, 5, 10)

        Log.d("@@@", one)
        Log.d("@@@", few)
        Log.d("@@@", many)

    }

    private fun initViews() {
        val b_english = findViewById<Button>(R.id.b_english)

        b_english.setOnClickListener {
            // setLocale("en")

            MyApplication.localManager!!.setNewLocale(this, LocaleManager.LANGUAGE_ENGLISH)
            finish()
        }

        val b_rusian = findViewById<Button>(R.id.b_russian)

        b_rusian.setOnClickListener {
            // setLocale("ru")
            MyApplication.localManager!!.setNewLocale(this, LocaleManager.LANGUAGE_RUSSIAN)
            finish()

        }
        val b_uzbek = findViewById<Button>(R.id.b_uzbek)
        b_uzbek.setOnClickListener {
            //setLocale("uz")
            MyApplication.localManager!!.setNewLocale(this, LocaleManager.LANGUAGE_UZBEK)
            finish()
        }
    }


    fun setLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale

        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        finish()
    }
}