package com.mirkamol.sharedpreference.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.mirkamol.sharedpreference.R
import com.mirkamol.sharedpreference.manager.SharePrefer

class HomeActivity : AppCompatActivity() {
    lateinit var editTextName: EditText
    lateinit var editTextEmail: EditText
    lateinit var buttonSave: Button
    lateinit var context: Context
    lateinit var sharePrefer: SharePrefer

    companion object {
        private const val KEY_NAME = "name"
        private const val KEY_EMAIL = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        editTextName = findViewById(R.id.edittext_name)
        editTextEmail = findViewById(R.id.edittext_email)
        buttonSave = findViewById(R.id.button_save)
        context = this
        sharePrefer = SharePrefer(context)

        if (SharePrefer(this).isSaved) {
            Intent(this, PreferenceActivity::class.java).also {
                startActivity(it)
            }
        }


        buttonSave.setOnClickListener {
            SharePrefer(this).isSaved = true


            val intent = Intent(this, PreferenceActivity::class.java)
            SharePrefer(context).setEmail(editTextEmail.text.toString())
            SharePrefer(context).setName(editTextName.text.toString())
            startActivity(intent)
        }

    }
}