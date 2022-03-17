package com.mirkamol.roomdatabasewithnetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mirkamol.roomdatabasewithnetworking.database.AppDatabase
import com.mirkamol.roomdatabasewithnetworking.database.entity.Post
import com.mirkamol.roomdatabasewithnetworking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var appDatabase: AppDatabase
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDatabase = AppDatabase.getInstance(this)


        settupUI()

    }

    private fun settupUI() {
        var post = Post( title = "PDP2", body = "Academy7263")
        binding.apply {
            add.setOnClickListener {
                appDatabase.PostDao().createPost(post)
            }

            deleteOne.setOnClickListener {
                appDatabase.PostDao().deletePost(2)
            }

            delete.setOnClickListener {
               // appDatabase.PostDao().deletePostwithDelete(post)
                appDatabase.PostDao().clearPosts()
            }

            update.setOnClickListener {
              //  appDatabase.PostDao().deletePost(1)
                appDatabase.PostDao().updatePost("Cloud", 41)
               // appDatabase.PostDao().updateWithUpdate(post)
            }


            getAll.setOnClickListener {
                Log.d("responce", appDatabase.PostDao().getPosts().toString())
            }
            getOne.setOnClickListener {
                Log.d("responce", appDatabase.PostDao().getPhoto(44).toString())
            }

        }
    }
}