package com.mirkamol.uzblogsretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirkamol.uzblogsretrofit.R
import com.mirkamol.uzblogsretrofit.model.PostModel
import com.mirkamol.uzblogsretrofit.model.UserModel


class PostAdapter(val items: List<PostModel>) : RecyclerView.Adapter<PostAdapter.ItemHolder>() {
    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvDate = view.findViewById<TextView>(R.id.tvDate)
        val imgPost = view.findViewById<ImageView>(R.id.imgPost)
    }


    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: PostAdapter.ItemHolder, position: Int) {
        val item = items[position]
        holder.tvTitle.text = item.text
        holder.tvDate.text = item.publishDate

        Glide.with(holder.itemView.context).load(item.image).into(holder.imgPost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item_layout, parent, false)
        )
    }
}