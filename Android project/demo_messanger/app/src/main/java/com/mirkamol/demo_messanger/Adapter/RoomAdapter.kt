package com.mirkamol.demo_messanger.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_messanger.R
import com.mirkamol.demo_messanger.model.Room

class RoomAdapter(val context: Context, val items: ArrayList<Room>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_room_view, parent, false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val room = items[position]
        if (holder is RoomViewHolder) {
            val ivProfile = holder.ivProfile
            val tvFullName = holder.tvFullName

            ivProfile.setImageResource(room.profile)
            tvFullName.text = room.fullname
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile: ShapeableImageView
        val tvFullName: TextView

        init {
            ivProfile = view.findViewById(R.id.iv_profile)
            tvFullName = view.findViewById(R.id.tv_fullname)
        }
    }


}