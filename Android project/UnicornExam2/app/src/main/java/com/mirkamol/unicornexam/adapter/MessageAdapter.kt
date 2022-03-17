package com.mirkamol.unicornexam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.unicornexam.R
import com.mirkamol.unicornexam.model.Collection
import com.mirkamol.unicornexam.model.Message

class MessageAdapter(val context: Context, val items:ArrayList<Message>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class MessageViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.iv_profile)
        val name = view.findViewById<TextView>(R.id.tv_fullname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is MessageViewHolder){
            holder.image.setImageResource(item.profile)
            holder.name.text = item.fullname
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}