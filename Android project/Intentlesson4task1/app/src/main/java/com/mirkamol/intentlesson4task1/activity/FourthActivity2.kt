package com.mirkamol.intentlesson4task1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.mirkamol.intentlesson4task1.R
import com.mirkamol.intentlesson4task1.model.Member
import com.mirkamol.intentlesson4task1.model.Person
import org.w3c.dom.Text

class FourthActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth2)


        initViews()

    }

    fun backToFinish() {
        val returnIntent = Intent()
        val person = Person("Muhammadyusuf", "22")
        returnIntent.putExtra("result", person)
        setResult(RESULT_OK, returnIntent)
        finish()
    }

    private fun initViews() {
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val to_go_back = findViewById<Button>(R.id.btn_button)

        to_go_back.setOnClickListener {
            backToFinish()
        }

        val member = intent.getSerializableExtra("member")
        tv_text.text = member.toString()
    }

}