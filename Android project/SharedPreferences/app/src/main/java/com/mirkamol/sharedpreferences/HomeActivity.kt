package com.mirkamol.sharedpreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    lateinit var textViewName: TextView
    lateinit var textViewEmail: TextView
    lateinit var buttonLogout: Button
    lateinit var sharedPreferences: SharedPreferences

    companion object{
        private const val SHARED_PREF_NAME = "mypref"
        private const val KEY_NAME = "name"
        private const val KEY_EMAIL = "email"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        textViewName = findViewById(R.id.text_fullname)
        textViewEmail = findViewById(R.id.text_email)
        buttonLogout = findViewById(R.id.button_logout)

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)
        val name = sharedPreferences.getString(KEY_NAME, null)
        val email = sharedPreferences.getString(KEY_EMAIL, null)


        if (name !=null || email != null){
            textViewName.setText("Full Name"+name)
            textViewEmail.setText("Email ID -"+email)
        }

        buttonLogout.setOnClickListener {
            val editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()
            finish()
            Toast.makeText(this, "Log out successfully", Toast.LENGTH_SHORT).show()
        }
    }
}