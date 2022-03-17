package com.mirkamol.sharedpreference.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.asLiveData
import com.mirkamol.sharedpreference.AppPref
import com.mirkamol.sharedpreference.R
import com.mirkamol.sharedpreference.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appPref: AppPref
    var age = 12
    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appPref = AppPref(this)
        buttonSave()
        observeData()
    }

    private fun observeData() {
        appPref.userName.asLiveData().observe(this) {
            name = it
            binding.tvName.text = it
        }
        appPref.userAge.asLiveData().observe(this) {

            name = it.toString()
        }
    }

    private fun buttonSave() {
        binding.apply {
            btnSave.setOnClickListener{
                name = etName.text.toString()
                age = etAge.text.toString().toInt()


                GlobalScope.launch {
                    appPref.storeUser(age, name)
                }
            }
        }
    }
}