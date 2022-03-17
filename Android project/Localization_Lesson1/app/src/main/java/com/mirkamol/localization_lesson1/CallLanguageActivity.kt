package com.mirkamol.localization_lesson1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class CallLanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_language)

        initViews()


    }

    private fun initViews() {
        val lan_english = findViewById<Button>(R.id.lan_english)
        lan_english.setOnClickListener {
            setLocal("en")
        }
        val lan_japan = findViewById<Button>(R.id.lan_japan)
        lan_japan.setOnClickListener {
            setLocal("Ja")
        }
        val lan_korean = findViewById<Button>(R.id.lan_korean)
        lan_korean.setOnClickListener {
            setLocal("Ko")
        }
        val lan_uzbek = findViewById<Button>(R.id.lan_uzbek)
        lan_uzbek.setOnClickListener {
            setLocal("Uz")
        }

    }

    private fun setLocal(language:String) {
      val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        finish()

    }


}