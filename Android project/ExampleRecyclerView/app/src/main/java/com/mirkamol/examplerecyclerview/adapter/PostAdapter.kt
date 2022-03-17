package com.mirkamol.examplerecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirkamol.examplerecyclerview.R
import com.mirkamol.examplerecyclerview.model.Post

class PostAdapter( val context: Context, val items: ArrayList<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class CustomPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.ic_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_click_layout, parent, false)
        return CustomPostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is CustomPostViewHolder){
            Glide.with(context).load(item.image).into(holder.image)

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}