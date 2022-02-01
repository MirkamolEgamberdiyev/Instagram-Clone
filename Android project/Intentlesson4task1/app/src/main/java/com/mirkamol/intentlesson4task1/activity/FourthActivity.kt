package com.mirkamol.intentlesson4task1.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.mirkamol.intentlesson4task1.R
import com.mirkamol.intentlesson4task1.model.Member

class FourthActivity : AppCompatActivity() {
    lateinit var btn_button: Button
    lateinit var tv_text1: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        initViews()
    }

    private fun initViews() {
        btn_button = findViewById(R.id.btn_button1)
        tv_text1 = findViewById(R.id.tv_text1)

        val detailLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val text = data!!.getSerializableExtra("result")
                tv_text1.text = text.toString()

            }
        }

        btn_button.setOnClickListener {
            val intent = Intent(this, FourthActivity2::class.java)
            val member = Member("Mirkamol", "22")
            intent.putExtra("member", member)
            detailLauncher.launch(intent)

        }


    }
}