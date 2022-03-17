package com.mirkamol.networkingwithimageupload.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.button.MaterialButton
import com.mirkamol.networkingwithimageupload.R
import com.mirkamol.networkingwithimageupload.networking.ApiClient
import com.mirkamol.networkingwithimageupload.networking.ApiService

class SecondActivity : AppCompatActivity() {

    lateinit var ivPhoto: ImageView
    lateinit var btnUpload: MaterialButton

    private lateinit var apiService: ApiService

    lateinit var fileUri: Uri

    val PICK_IMAGE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        apiService = ApiClient.postService



    }
}