package com.mirkamol.multipartb13

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.mirkamol.multipartb13.api.ApiClient
import com.mirkamol.multipartb13.api.ApiService
import com.mirkamol.multipartb13.model.ImageResponce
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.util.jar.Manifest

private const val IMAGE_PICK_CODE = 1

class MainActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService
    private var catPhoto: File = File("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = ApiClient.createServiceWithAuth(ApiService::class.java)
        setupUI()

    }

    private fun setupUI() {
        var pickImage = findViewById<Button>(R.id.pickImage)
        var uploadImage = findViewById<Button>(R.id.uploadImage)

        pickImage.setOnClickListener {
            checkPermission()
        }

        uploadImage.setOnClickListener {
            val builder: MultipartBody.Builder = MultipartBody.Builder()
            builder.setType(MultipartBody.FORM)

            if (catPhoto.length() > 0) {
                builder.addFormDataPart(
                    "file", catPhoto.name,
                    catPhoto.asRequestBody("image/*".toMediaType())
                )
                builder.addFormDataPart("sub_id", "something")

                val body = builder.build()

                apiService.uploadPhoto(body).enqueue(object : Callback<ImageResponce> {
                    override fun onResponse(
                        call: Call<ImageResponce>,
                        response: Response<ImageResponce>
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            response.body().toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onFailure(call: Call<ImageResponce>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT)
                            .show()
                    }

                })
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_OK && resultCode == RESULT_OK) {
            var fileUri = data?.data!!

            val ins = this.contentResolver.openInputStream(fileUri)
            catPhoto = File.createTempFile(
                "file",
                ".jpg",
                this.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            )

            val fileOutputStream = FileOutputStream(catPhoto)

            ins?.copyTo(fileOutputStream)
            ins?.close()
            fileOutputStream.close()
        }

    }

    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                listOf(Manifest.permission.READ_EXTERNAL_STORAGE).toTypedArray(),
                IMAGE_PICK_CODE
            )
        } else {
            startGallery()
        }
    }

    private fun startGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        val mimeTypes = arrayOf("image/jpeg", "image/png")
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }
}