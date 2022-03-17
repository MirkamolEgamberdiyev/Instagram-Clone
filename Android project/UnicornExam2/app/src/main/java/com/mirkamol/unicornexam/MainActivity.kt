package com.mirkamol.unicornexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.unicornexam.adapter.PostAdapter
import com.mirkamol.unicornexam.model.Post

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
       recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        refreshAdapter(getAllPost())

        findViewById<ImageView>(R.id.home).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.sort).setOnClickListener {
            val intent = Intent(this, CollectionsActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.chat).setOnClickListener {
            val intent = Intent(this, MessageActivity::class.java)
            startActivity(intent)
        }

    }

    private fun refreshAdapter(items:ArrayList<Post>) {
        val adapter = PostAdapter(this, items)
        recyclerView.adapter = adapter
    }

    fun getAllPost():ArrayList<Post>{
        val posts = ArrayList<Post>()

        for (i in 0..20){
            posts.add(Post(R.drawable.img, "Restaurants"))
        }

        return posts
    }
}