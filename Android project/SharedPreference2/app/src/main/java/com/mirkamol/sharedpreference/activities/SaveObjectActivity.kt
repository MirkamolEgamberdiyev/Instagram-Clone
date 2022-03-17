package com.mirkamol.sharedpreference.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.button.MaterialButton
import com.mirkamol.sharedpreference.R
import com.mirkamol.sharedpreference.manager.SharePrefer
import com.mirkamol.sharedpreference.model.User

internal lateinit var sharedPrefer:SharePrefer
class SaveObjectActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var tvObject:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_object)

        sharedPrefer = SharePrefer(this)


        tvObject = findViewById(R.id.tvObject)
        findViewById<MaterialButton>(R.id.btnObject).setOnClickListener(this)
        findViewById<MaterialButton>(R.id.btnSavedObject).setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnObject ->{
                sharedPrefer.saveUser("user", User("Mirkamol", 22))
            }
            R.id.btnSavedObject ->{
                val user = sharedPrefer.getUser("user")
                tvObject.text = user.toString()
            }
        }
    }


}