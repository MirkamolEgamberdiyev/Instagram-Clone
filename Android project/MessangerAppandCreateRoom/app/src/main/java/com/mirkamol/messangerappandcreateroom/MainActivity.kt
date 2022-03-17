package com.mirkamol.messangerappandcreateroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.messangerappandcreateroom.adapter.ChatAdapter
import com.mirkamol.messangerappandcreateroom.adapter.RoomAdapter
import com.mirkamol.messangerappandcreateroom.model.Message
import com.mirkamol.messangerappandcreateroom.model.Room

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    private lateinit var topRecyclerView: RecyclerView
    lateinit var peopleImage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()


        peopleImage = findViewById(R.id.people_image)
        peopleImage.setOnClickListener {
            peopleActivity()
        }




    }

    private fun initViews() {
        recyclerView = findViewById(R.id.bottomRecycler)
        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter=ChatAdapter(messageList())

        topRecyclerView = findViewById(R.id.topRecycler)
        topRecyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        topRecyclerView.adapter=RoomAdapter(roomAdapterList())

    }

    private fun messageList():ArrayList<Message>{
        val messageList=ArrayList<Message>()
        for (i in 0..30){
            if (i%2==0){
                messageList.add(Message(R.drawable.ic_profile,"Mirkamol", false))
            }else{
                messageList.add(Message(R.drawable.ic_profile,"Mirkamol", true))
            }
        }
        return messageList
    }
    private fun roomAdapterList():ArrayList<Room>{
        val roomList=ArrayList<Room>()
        for (i in 0..30){
            if (i==0){
                roomList.add(Room(R.drawable.ic_baseline_video_call_24,"Create Room"))
            }else{
                roomList.add(Room(R.drawable.ic_profile,"Mirkamol"))
            }
        }
        return roomList
    }



    private fun peopleActivity(){
        val intent = Intent(this, PeopleActivity::class.java)
        startActivity(intent)
    }
}