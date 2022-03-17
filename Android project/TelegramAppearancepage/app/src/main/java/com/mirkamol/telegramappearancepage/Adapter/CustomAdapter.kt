package com.mirkamol.telegramappearancepage.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.telegramappearancepage.R
import com.mirkamol.telegramappearancepage.model.ChatBackround

class CustomAdapter(val items:ArrayList<ChatBackround>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class CustomViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.image)
        val image_1 = view.findViewById<ImageView>(R.id.image_1)
        val image_2 = view.findViewById<ImageView>(R.id.image_2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_latout_home, parent, false)
       return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is CustomViewHolder){
            holder.image.setImageResource(item.image)
            holder.image_1.setImageResource(item.image1)
            holder.image_2.setImageResource(item.image2)

        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

}