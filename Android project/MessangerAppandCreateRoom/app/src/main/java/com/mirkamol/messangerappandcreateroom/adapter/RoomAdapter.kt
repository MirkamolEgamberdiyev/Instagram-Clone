package com.mirkamol.messangerappandcreateroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.messangerappandcreateroom.R
import com.mirkamol.messangerappandcreateroom.model.Room

class RoomAdapter(val items: ArrayList<Room>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class CreateRoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        val fullname = view.findViewById<TextView>(R.id.tv_fullname)
    }
    inner class RoomSuggestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        val fullname = view.findViewById<TextView>(R.id.tv_fullname)

    }


    companion object{
        private const val TYPE_ITEM_ROOM_CREATE = 0
        private const val TYPE_ITEM_ROOM = 1
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return TYPE_ITEM_ROOM_CREATE
        return TYPE_ITEM_ROOM
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM_CREATE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_create_room, parent, false)
            return CreateRoomViewHolder(view)
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
        return RoomSuggestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is RoomSuggestionViewHolder){
            holder.fullname.text=item.fullname
        }
        if (holder is CreateRoomViewHolder){
            holder.fullname.text=item.fullname
            holder.profile.setImageResource(item.profile)
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }
}