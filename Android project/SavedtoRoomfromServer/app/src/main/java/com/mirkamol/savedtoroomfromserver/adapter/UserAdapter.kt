package com.mirkamol.savedtoroomfromserver.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirkamol.savedtoroomfromserver.R
import com.mirkamol.savedtoroomfromserver.model.UserItem

class UserAdapter ( val context:Context, val list:ArrayList<UserItem>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class UserViewHolder(view: View): RecyclerView.ViewHolder(view){
        val fullName = view.findViewById<TextView>(R.id.tv_name)
        val phoneNumber = view.findViewById<TextView>(R.id.tv_phoneNumber)
        val image = view.findViewById<ImageView>(R.id.iv_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.first_fragment_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = list[position]
        if (holder is UserViewHolder){
            holder.fullName.text = user.name
            holder.phoneNumber.text = user.phone.toString()
            Glide.with(context).load(user.image).into(holder.image)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}