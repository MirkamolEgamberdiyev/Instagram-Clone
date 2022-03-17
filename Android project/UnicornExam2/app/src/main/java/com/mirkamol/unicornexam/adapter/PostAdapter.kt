package com.mirkamol.unicornexam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.unicornexam.R
import com.mirkamol.unicornexam.model.Post

class PostAdapter(val context: Context, val items:ArrayList<Post>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class PostViewHolder(view:View):RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.imageView)
        val name = view.findViewById<TextView>(R.id.tv_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is PostViewHolder){
            holder.image.setImageResource(item.image)
            holder.name.text = item.name
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}