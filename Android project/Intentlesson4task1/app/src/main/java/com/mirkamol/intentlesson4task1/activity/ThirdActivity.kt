package com.mirkamol.intentlesson4task1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mirkamol.intentlesson4task1.R
import com.mirkamol.intentlesson4task1.model.User

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        initViews()
    }

    private fun initViews() {
        val person = findViewById<TextView>(R.id.task3)
        val user = intent.getParcelableExtra<User>("user")

        person.text = user.toString()
    }
}