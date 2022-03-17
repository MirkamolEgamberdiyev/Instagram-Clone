package com.mirkamol.unicornexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.unicornexam.adapter.CollectionAdapter
import com.mirkamol.unicornexam.adapter.MessageAdapter
import com.mirkamol.unicornexam.model.Collection
import com.mirkamol.unicornexam.model.Message

class MessageActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        initView()
    }

    private fun initView() {
        recyclerView = findViewById(R.id.messageRecyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        refreshAdapter(getAllPost())
    }

    private fun refreshAdapter(items: ArrayList<Message>) {
        val adapter = MessageAdapter(this, items)
        recyclerView.adapter = adapter
    }

    fun getAllPost(): ArrayList<Message> {
        val posts = ArrayList<Message>()

        for (i in 0..20) {
            posts.add(Message(R.drawable.profile, "Restaurants"))
        }

        return posts
    }
}