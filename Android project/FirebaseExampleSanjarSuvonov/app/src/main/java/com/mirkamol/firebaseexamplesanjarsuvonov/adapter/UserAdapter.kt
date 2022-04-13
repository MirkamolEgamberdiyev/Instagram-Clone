package com.mirkamol.firebaseexamplesanjarsuvonov.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.firebaseexamplesanjarsuvonov.R
import com.mirkamol.firebaseexamplesanjarsuvonov.model.User

class UserAdapter(var users: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.Vh>() {
    class Vh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(user: User) {
            val tv = itemView.findViewById<TextView>(R.id.tv)
            tv.text = user.name + user.email + user.password
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(users[position])
    }

    override fun getItemCount(): Int = users.size
}