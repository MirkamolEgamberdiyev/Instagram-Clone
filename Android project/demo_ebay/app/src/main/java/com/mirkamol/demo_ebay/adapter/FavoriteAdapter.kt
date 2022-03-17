package com.mirkamol.demo_ebay.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.demo_ebay.R
import com.mirkamol.demo_ebay.model.Favorite

class FavoriteAdapter(var context: Context, var items:ArrayList<Favorite>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_favorite, parent, false)

        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      val item = items[position]

        if (holder is StoryViewHolder){
            var tv_title = holder.tv_title
            var iv_image = holder.iv_image

            iv_image.setImageResource(item.image)
            tv_title.text = item.title
        }
    }

    override fun getItemCount(): Int {
      return items.size
    }

    inner class StoryViewHolder(view:View):RecyclerView.ViewHolder(view){
        var iv_image:ImageView
        var tv_title:TextView

        init {
            iv_image = view.findViewById(R.id.iv_image)
            tv_title = view.findViewById(R.id.tv_title)
        }
    }

}