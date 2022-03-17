package com.mirkamol.intermediatelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.intermediatelayout.Adapter.ChatAdapter
import com.mirkamol.intermediatelayout.model.Chat

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        initViews()
    }

    private fun initViews() {
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(this, chats)
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = LinearLayoutManager::class.java.cast(recyclerView.layoutManager)
                val totalItemCount = layoutManager.itemCount
                val lastVisible = layoutManager.findLastVisibleItemPosition()
                val endHasBeenReached = lastVisible + 5 >= totalItemCount

                if (totalItemCount > 0 && endHasBeenReached){
                 //   Snackbar.make(recyclerView, "End", Snackbar.LENGTH_SHORT).show()
                    adapter.addChats(getAllChats())
                }
            }
        })
    }

    private fun getAllChats(): ArrayList<Chat> {
        val chats = ArrayList<Chat>()
        chats.add(Chat(R.drawable.ic_image, "Mirkamol Egamberdiyev", 1))
        chats.add(Chat(R.drawable.im_user_2, "Mirkamol Egamberdiyev", 2))
        chats.add(Chat(R.drawable.im_user_2, "Mirkamol Egamberdiyev", 0))
        chats.add(Chat(R.drawable.im_user_2, "Mirkamol Egamberdiyev", 3))
        chats.add(Chat(R.drawable.im_user_2, "Mirkamol Egamberdiyev", 1))
        chats.add(Chat(R.drawable.ic_image, "Mirkamol Egamberdiyev", 1))

        return chats
    }


}