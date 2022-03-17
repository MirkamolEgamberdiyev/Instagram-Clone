package com.mirkamol.demo_instagram.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirkamol.demo_instagram.R
import com.mirkamol.demo_instagram.model.Story

class StoryAdapter(var context: Context, var items:ArrayList<Story>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)

        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is StoryViewHolder){
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname

            Glide.with(context).load(story.profile).into(iv_profile)
            tv_fullname.text = story.fullname

         //   iv_profile.setImageResource(story.profile)

        }


    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class StoryViewHolder(view:View):RecyclerView.ViewHolder(view){
        var iv_profile:ImageView
        var tv_fullname:TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
}