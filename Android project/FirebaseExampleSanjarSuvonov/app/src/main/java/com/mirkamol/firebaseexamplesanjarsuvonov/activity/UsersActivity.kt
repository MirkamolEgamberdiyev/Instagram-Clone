package com.mirkamol.firebaseexamplesanjarsuvonov.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.mirkamol.firebaseexamplesanjarsuvonov.R
import com.mirkamol.firebaseexamplesanjarsuvonov.adapter.UserAdapter
import com.mirkamol.firebaseexamplesanjarsuvonov.model.User

class UsersActivity : AppCompatActivity() {
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var reference: DatabaseReference
    lateinit var recyclerView: RecyclerView
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        recyclerView = findViewById(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)
        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("users/")
        addValueEventListener()

    }

    fun addValueEventListener() {
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<User>()
                for (snapshot1 in snapshot.children) {
                    val user = snapshot1.getValue(User::class.java)
                    if (user != null) {
                        list.add(user)
                    }
                }
                userAdapter = UserAdapter(list)
                recyclerView.adapter = userAdapter
                Log.d("TAG", "onDataChange: $list")
                Log.d("user : ", snapshot.toString())
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}