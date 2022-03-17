package com.mirkamol.messangerappandcreateroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.messangerappandcreateroom.R
import com.mirkamol.messangerappandcreateroom.model.StoriesModel
import java.lang.Exception

class StoriesAdapter(private val items: ArrayList<StoriesModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class StoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profile = view.findViewById<ImageView>(R.id.backgroundImage)
        val userName = view.findViewById<TextView>(R.id.userName)
        val circleImage = view.findViewById<ShapeableImageView>(R.id.circleImage)
        val counter  =view.findViewById<TextView>(R.id.counter)


    }
    inner class CreateStoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.backgroundImage)
        val addStorie = view.findViewById<TextView>(R.id.txtCounter)
        val userName = view.findViewById<TextView>(R.id.tv_fullname)

    }


    companion object{
        private const val TYPE_ITEM_ROOM_CREATE = 0
        private const val TYPE_ITEM_ROOM = 1
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return TYPE_ITEM_ROOM
        return TYPE_ITEM_ROOM_CREATE
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM_CREATE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
            return StoriesViewHolder(view)
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_add_story, parent, false)
        return CreateStoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if(holder is StoriesViewHolder){
            holder.profile.setImageResource(item.image)
            holder.circleImage.setImageResource(item.circleImage)
            holder.userName.text = item.userName
            holder.counter.text = item.number.toString()
        }

        if (holder is CreateStoryViewHolder){
            holder.image.setImageResource(item.image)

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}