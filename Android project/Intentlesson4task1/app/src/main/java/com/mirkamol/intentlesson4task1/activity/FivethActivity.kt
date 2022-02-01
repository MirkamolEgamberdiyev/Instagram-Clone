package com.mirkamol.intentlesson4task1.activity
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mirkamol.intentlesson4task1.R
import com.mirkamol.intentlesson4task1.model.Human
import com.mirkamol.intentlesson4task1.model.User

class FivethActivity : AppCompatActivity() {
    lateinit var tvHome: TextView
    companion object {
        const val START_ACTIVITY_3_REQUEST_CODE = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiveth)
        tvHome = findViewById(R.id.tv_text1)

        initViews()
    }

    private fun initViews() {
        val btnDetail = findViewById<Button>(R.id.btn_button1)
        btnDetail.setOnClickListener {
            val user = User("Mirkamol", "22")
            openDetailActivity(user)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == START_ACTIVITY_3_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val human = data!!.getParcelableExtra<Human>("human")
                tvHome.text = human.toString()
            }
        }
    }

    private fun openDetailActivity(user: User) {
        val intent = Intent(this, FivethActivity2::class.java)
        intent.putExtra("user", user)
        startActivityForResult(intent, START_ACTIVITY_3_REQUEST_CODE)
    }

}