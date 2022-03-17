package com.mirkamol.preferenceexample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mirkamol.preferenceexample.R
import com.mirkamol.preferenceexample.manager.PrefsManager

class PreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        initViews()

    }

    private fun initViews() {
        val etEmail = findViewById<EditText>(R.id.edt_email)
        val btnSave = findViewById<Button>(R.id.btn_save)
        val btnView = findViewById<Button>(R.id.btn_view)

        val prefsManager = PrefsManager.getInstance(this)

        btnSave.setOnClickListener {
            val email = etEmail.text.toString().trim()
            prefsManager!!.saveData("key", email)

          //  saveEmail(email)
        }

        btnView.setOnClickListener {
            Toast.makeText(this, prefsManager!!.getData("key"), Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveEmail(email: String?) {
        val prefs = applicationContext.getSharedPreferences("Mypref", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("email", email)
        editor.apply()
    }
}