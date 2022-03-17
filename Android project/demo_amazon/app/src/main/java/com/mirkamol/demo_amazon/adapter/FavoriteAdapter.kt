package com.mirkamol.demo_amazon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_amazon.R
import com.mirkamol.demo_amazon.model.Essential

class FavoriteAdapter(val context: Context, val items:ArrayList<Essential>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class EssantialViewHolder(view:View):RecyclerView.ViewHolder(view){

        var tv_title = view.findViewById<TextView>(R.id.tv_title)
        var iv_image = view.findViewById<ImageView>(R.id.iv_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_essential, parent, false)
        return EssantialViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is EssantialViewHolder){
            val tv_title = holder.tv_title
            val iv_image = holder.iv_image



            iv_image.setImageResource(item.image)
            tv_title.text = item.title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}