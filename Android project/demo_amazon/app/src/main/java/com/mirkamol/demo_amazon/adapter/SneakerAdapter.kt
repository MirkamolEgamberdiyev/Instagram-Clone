package com.mirkamol.demo_amazon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_amazon.R
import com.mirkamol.demo_amazon.model.Sneakers

class SneakerAdapter(val context: Context, val items:ArrayList<Sneakers>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class SneakerViewHolder(view:View):RecyclerView.ViewHolder(view){
        val ivPhoto1 = view.findViewById<ShapeableImageView>(R.id.iv_photo1)
        val ivPhoto2 = view.findViewById<ShapeableImageView>(R.id.iv_photo2)
        val ivPhoto3 = view.findViewById<ShapeableImageView>(R.id.iv_photo3)
        val ivPhoto4 = view.findViewById<ShapeableImageView>(R.id.iv_photo4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sneaker, parent, false)
        return SneakerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val item = items[position]

        if (holder is SneakerViewHolder){
            holder.ivPhoto1.setImageResource(item.image1)
            holder.ivPhoto2.setImageResource(item.image2)
            holder.ivPhoto3.setImageResource(item.image3)
            holder.ivPhoto4.setImageResource(item.image4)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}