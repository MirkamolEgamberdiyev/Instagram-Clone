package com.mirkamol.demo_twitter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_twitter.R
import com.mirkamol.demo_twitter.model.PostDouble

class PostAdapter(var items: ArrayList<PostDouble>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_post1: ShapeableImageView
        var tv_fullname: TextView
        var iv_post2: ShapeableImageView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_post1 = view.findViewById(R.id.iv_post1)
            tv_fullname = view.findViewById(R.id.tv_fullname)
            iv_post2 = view.findViewById(R.id.iv_post2)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post2, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      val item = items[position]
        if (holder is PostViewHolder){
            holder.iv_profile.setImageResource(item.profile)
            holder.iv_post1.setImageResource(item.photo1)
            holder.iv_post2.setImageResource(item.photo2)
            holder.tv_fullname.text = item.fullname
        }
    }

    override fun getItemCount(): Int {
     return items.size
    }
}