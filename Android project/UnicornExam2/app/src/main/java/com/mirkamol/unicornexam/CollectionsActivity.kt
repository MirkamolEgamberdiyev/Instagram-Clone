package com.mirkamol.unicornexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.unicornexam.adapter.CollectionAdapter
import com.mirkamol.unicornexam.adapter.PostAdapter
import com.mirkamol.unicornexam.model.Collection
import com.mirkamol.unicornexam.model.Post

class CollectionsActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collections)

        initView()
    }

    private fun initView() {
        recyclerView = findViewById(R.id.colectionrecyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        refreshAdapter(getAllPost())
    }

    private fun refreshAdapter(items:ArrayList<Collection>) {
        val adapter = CollectionAdapter(this, items)
        recyclerView.adapter = adapter
    }

    fun getAllPost():ArrayList<Collection>{
        val posts = ArrayList<Collection>()

        for (i in 0..20){
            posts.add(Collection(R.drawable.img, "Restaurants"))
        }

        return posts
    }
}