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
import com.mirkamol.unicornexam.model.Post

class CollectionAdapter(val context: Context, val items:ArrayList<Collection>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class CollectionViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.photo)
        val name = view.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_collection, parent, false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is CollectionViewHolder){
            holder.image.setImageResource(item.image)
            holder.name.text = item.name
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}