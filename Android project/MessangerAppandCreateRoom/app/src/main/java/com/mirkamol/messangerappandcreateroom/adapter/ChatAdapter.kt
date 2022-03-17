package com.mirkamol.messangerappandcreateroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.messangerappandcreateroom.R
import com.mirkamol.messangerappandcreateroom.model.Message

class ChatAdapter( val message: ArrayList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        val fullname = view.findViewById<TextView>(R.id.tv_fullname)
        val isOnline = view.findViewById<LinearLayout>(R.id.is_online)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is MessageViewHolder) {
            val ivProfile = holder.profile
            val tvFullname = holder.fullname
            val isOnline = holder.isOnline

            ivProfile.setImageResource(message[position].profile)
            tvFullname.text = message[position].fullname

            if (message[position]!!.isOnline) {
                isOnline.visibility = View.VISIBLE
            } else {
                isOnline.visibility = View.GONE
            }
        }

    }

    override fun getItemCount(): Int {
        return message.size
    }
}