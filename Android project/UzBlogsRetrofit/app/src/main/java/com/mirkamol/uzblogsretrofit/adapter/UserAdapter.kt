package com.mirkamol.uzblogsretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirkamol.uzblogsretrofit.R
import com.mirkamol.uzblogsretrofit.model.UserModel

class UserAdapter(val items:List<UserModel>, val userAdapterListener: UserAdapterListener) :RecyclerView.Adapter<UserAdapter.ItemHolder>(){
    inner class ItemHolder(view:View):RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val imgUser = view.findViewById<ImageView>(R.id.imgUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
      val item = items[position]

        holder.imgUser.setOnClickListener {
            userAdapterListener.onClick(item)
        }
        holder.tvName.text = item.firstName
        Glide.with(holder.itemView.context).load(item.picture).into(holder.imgUser)

    }

    override fun getItemCount(): Int {
      return items.count()
    }
}