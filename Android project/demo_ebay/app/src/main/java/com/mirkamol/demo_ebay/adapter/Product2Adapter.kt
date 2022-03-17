package com.mirkamol.demo_ebay.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_ebay.R
import com.mirkamol.demo_ebay.model.Product2

class Product2Adapter(val items:ArrayList<Product2>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class Product2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image2 = view.findViewById<ShapeableImageView>(R.id.image2)
        val titleProduct2 = view.findViewById<TextView>(R.id.title_product2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product2, parent, false)
        return Product2ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is Product2ViewHolder){
            holder.image2.setImageResource(item.image2)
            holder.titleProduct2.text = item.title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}