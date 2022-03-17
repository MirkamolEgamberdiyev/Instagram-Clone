package com.mirkamol.sharedpreference.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mirkamol.sharedpreference.R
import com.mirkamol.sharedpreference.manager.SharedPreference

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var tvSharedPref: TextView
    private lateinit var tvInt: TextView
    private lateinit var tvLong: TextView
    private lateinit var tvBoolean: TextView
    private lateinit var tvFloat: TextView
    private lateinit var sharedPreferences: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        context = this
        tvSharedPref = findViewById(R.id.tv_text)
        tvBoolean = findViewById(R.id.tv_boolean)
        tvFloat = findViewById(R.id.tv_float)
        tvInt = findViewById(R.id.tv_int)
        tvLong = findViewById(R.id.tv_long)

        sharedPreferences = SharedPreference(context)

        controlSharedPref()
    }

    private fun controlSharedPref() {
      sharedPreferences.setString("i like android")
        tvSharedPref.text = sharedPreferences.getString()


        sharedPreferences.setFloat(10F)
        tvFloat.text = sharedPreferences.getFloat().toString()

        sharedPreferences.setBoolean(true)
        tvBoolean.text = sharedPreferences.getBoolean().toString()

        sharedPreferences.setInt(11)
        tvInt.text = sharedPreferences.getInt().toString()

        sharedPreferences.setLong(12L)
        tvLong.text = sharedPreferences.getLong().toString()


    }
}