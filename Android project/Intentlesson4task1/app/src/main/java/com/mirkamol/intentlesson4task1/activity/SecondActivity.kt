package com.mirkamol.intentlesson4task1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.mirkamol.intentlesson4task1.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()

    }

    private fun initViews() {
        val person = findViewById<TextView>(R.id.task2)
        val member = intent.getSerializableExtra("user")

        person.text = member.toString()

    }
}