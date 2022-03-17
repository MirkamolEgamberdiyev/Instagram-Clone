package com.mirkamol.demo_messanger.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_messanger.R
import com.mirkamol.demo_messanger.model.Chat
import com.mirkamol.demo_messanger.model.Room


class ChatAdapter(val context: Context, val items: ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]
        if (feed.rooms.size > 0)
            return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)

            return RoomViewHolder( view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]
        if (holder is RoomViewHolder){
            val recyclerView = holder.recyclerView
            refreshAdapter(message.rooms, recyclerView)
        }

        if (holder is MessageViewHolder){
            val ivProfile = holder.iv_profile
            val tvFullname = holder.tv_fullname
            val isOnline = holder.is_online


            ivProfile.setImageResource(message.message!!.profile)
            tvFullname.text = message.message!!.fullname
            if (message.message!!.isonline){
                isOnline.visibility = View.VISIBLE
            }else{
                isOnline.visibility = View.GONE
            }

        }
    }


    fun refreshAdapter(rooms:ArrayList<Room>, recyclerView: RecyclerView){
        val adapter = RoomAdapter(context, rooms)
        recyclerView!!.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class RoomViewHolder( view: View):RecyclerView.ViewHolder(view){
         var recyclerView:RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = manager
        }

    }

    inner class MessageViewHolder( view:View):RecyclerView.ViewHolder(view){
        val iv_profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        val tv_fullname = view.findViewById<TextView>(R.id.tv_fullname)
        val is_online = view.findViewById<LinearLayout>(R.id.is_online)

    }
}