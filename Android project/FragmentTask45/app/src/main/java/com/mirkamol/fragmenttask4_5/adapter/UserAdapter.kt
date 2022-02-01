package com.example.fragmenttask5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttask5.R
import com.example.fragmenttask5.model.User

class UserAdapter(private var userList:ArrayList<User>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userList[position]
        if (holder is UserViewHolder){
            holder.apply {
                textName.text = user.name
                description.text = user.description
                image.setImageResource(R.drawable.img_sample_user)
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textName:TextView = view.findViewById(R.id.text_name_user)
        val description:TextView = view.findViewById(R.id.text_description_user)
        val image:ImageView = view.findViewById(R.id.imv_user)
    }
}