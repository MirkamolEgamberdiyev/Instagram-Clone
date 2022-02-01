package com.mirkamol.intentlesson4task1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mirkamol.intentlesson4task1.R
import org.w3c.dom.Text

class FirstAactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initViews()

    }

    private fun initViews() {
        val tv_name = findViewById<TextView>(R.id.name)
        val tv_age = findViewById<TextView>(R.id.age)
        var name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        tv_name.text = name
        tv_age.text = age

    }
}