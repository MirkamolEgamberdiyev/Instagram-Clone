package com.mirkamol.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var editTextName: EditText
    lateinit var editTextEmail: EditText
    lateinit var buttonSave: Button
    lateinit var sharedPreferences: SharedPreferences

    companion object{
        private const val SHARED_PREF_NAME = "mypref"
        private const val KEY_NAME = "name"
        private const val KEY_EMAIL = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.edittext_name)
        editTextEmail = findViewById(R.id.edittext_email)
        buttonSave = findViewById(R.id.button_save)

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)

        val name = sharedPreferences.getString(KEY_NAME, null)

        if (name != null){
             val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }


        buttonSave.setOnClickListener {
           val editor:SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putString(KEY_NAME, editTextName.text.toString())
            editor.putString(KEY_EMAIL, editTextEmail.text.toString())
            editor.apply()

            startActivity(Intent(this, HomeActivity::class.java))

            Toast.makeText(this, "Logen Success", Toast.LENGTH_SHORT).show()

        }


    }
}


