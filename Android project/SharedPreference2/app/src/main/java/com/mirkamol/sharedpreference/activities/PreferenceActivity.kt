package com.mirkamol.sharedpreference.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mirkamol.sharedpreference.R
import com.mirkamol.sharedpreference.manager.SharePrefer

class PreferenceActivity : AppCompatActivity() {
    lateinit var textViewName: TextView
    lateinit var textViewEmail: TextView
    lateinit var buttonLogout: Button
    lateinit var sharedPrefer: SharePrefer

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        textViewName = findViewById(R.id.text_fullname)
        textViewEmail = findViewById(R.id.text_email)
        buttonLogout = findViewById(R.id.button_logout)

        sharedPrefer = SharePrefer(this)


       // val email= SharePrefer(this).getEmail()
       // val name= SharePrefer(this).getName()

        val email = sharedPrefer.getEmail()
        val name = sharedPrefer.getName()


        textViewEmail.text=email
        textViewName.text=name

        buttonLogout.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }


    }
}