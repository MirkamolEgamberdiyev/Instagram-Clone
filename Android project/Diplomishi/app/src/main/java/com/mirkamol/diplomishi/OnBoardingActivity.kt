package com.mirkamol.diplomishi

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class OnBoardingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        initViews()

    }

    @SuppressLint("WrongViewCast")
    private fun initViews() {
        val ivTeacher = findViewById<ImageView>(R.id.iv_teacher)
        val ivStudent = findViewById<ImageView>(R.id.iv_student)
        val btnTecher = findViewById<Button>(R.id.btn_teacher)
        val btnStudent = findViewById<Button>(R.id.btn_student)


        ivTeacher.setOnClickListener {
            ivTeacher.setBackgroundColor(this.resources.getColor(R.color.green))
            btnTecher.visibility = View.VISIBLE
            ivStudent.setBackgroundColor(Color.WHITE)
            btnStudent.visibility = View.GONE

            btnTecher.setOnClickListener {
                callTeacherSignInActivity()
            }

        }

        ivStudent.setOnClickListener {
            ivStudent.setBackgroundColor(this.resources.getColor(R.color.green))
            btnStudent.visibility = View.VISIBLE
            ivTeacher.setBackgroundColor(Color.WHITE)
            btnTecher.visibility = View.GONE

            btnStudent.setOnClickListener {
                callStudentSignInActivity()
            }
        }
    }

    private fun callStudentSignInActivity() {
        val intent  = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun callTeacherSignInActivity() {
        val intent  = Intent(this, TeacherSignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}