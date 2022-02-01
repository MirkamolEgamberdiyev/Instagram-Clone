package com.mirkamol.nestedscrolviewandrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initViews()
    }

    private fun initViews() {
        val ll_details = findViewById<TextView>(R.id.ll_details)
        val contact = intent.getSerializableExtra("contact")

        ll_details.text = contact.toString()
    }
}