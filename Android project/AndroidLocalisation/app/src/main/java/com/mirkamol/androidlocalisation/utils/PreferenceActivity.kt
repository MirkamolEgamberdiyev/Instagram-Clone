package com.mirkamol.androidlocalisation.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mirkamol.androidlocalisation.R
import com.mirkamol.androidlocalisation.manager.PrefsManager

class PreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        initViews()


    }

    private fun initViews() {
        val et_email = findViewById<EditText>(R.id.et_email)
        val b_save = findViewById<Button>(R.id.b_save)
        val btnView: Button = findViewById(R.id.btn_view)

        val prefsManager = PrefsManager.getInstance(this)

        b_save.setOnClickListener {
            val email = et_email.text.toString().trim()
            prefsManager!!.saveData("key",email)
//            val email = et_email.text.toString()
//            saveEmail(email)
        }
        btnView.setOnClickListener {
            Toast.makeText(this, prefsManager!!.getData("key"), Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveEmail(email: String?) {
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("email", email)
        editor.apply()
    }

    fun loadEmail():String?{
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        return prefs.getString("email", "pdp@gmail.com")
    }

    fun removeEmail(){
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.remove("email")
        editor.apply()
    }

    fun clearAll(){
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}