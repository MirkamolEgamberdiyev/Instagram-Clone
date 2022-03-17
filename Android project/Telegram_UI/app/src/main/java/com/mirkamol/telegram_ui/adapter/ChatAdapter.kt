package com.mirkamol.telegram_ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.telegram_ui.R
import com.mirkamol.telegram_ui.model.Chat

class ChatAdapter(val context: Context, val items:ArrayList<Chat>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    inner class MessageViewHolder(view:View):RecyclerView.ViewHolder(view){
        var profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        var fullName = view.findViewById<TextView>(R.id.tv_fullname)
        var message = view.findViewById<TextView>(R.id.tv_meesage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_view, parent, false)

        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]

        if (holder is MessageViewHolder){
            val iv_profile = holder.profile
            val tv_fullname = holder.fullName
            val tv_message = holder.message


            iv_profile.setImageResource(chat.profile)
            tv_fullname.setText(chat.fullname)
            tv_message.setText(chat.message)
        }
    }

    override fun getItemCount(): Int {
      return items.size
    }
}