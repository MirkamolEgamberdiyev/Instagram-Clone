package com.mirkamol.fragmentbyrecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.fragmentbyrecyclerview.R
import com.mirkamol.fragmentbyrecyclerview.model.User

class UserAdapter(val users: ArrayList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class UserViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tv_userName: TextView = view.findViewById(R.id.tv_username)
        val tv_password: TextView = view.findViewById(R.id.tv_password)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false)
        return UserViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val user = users[position]
        if (holder is UserViewHolder){
            holder.tv_userName.setText(user.userName)
            holder.tv_password.setText(user.password)
        }
    }

    override fun getItemCount(): Int {
     return users.size
    }
}