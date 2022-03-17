package com.mirkamol.demo_ebay.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_ebay.R
import com.mirkamol.demo_ebay.model.Product1

class Product1Adapter(val items: ArrayList<Product1>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class Product1ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image1 = view.findViewById<ShapeableImageView>(R.id.image1)
        val titleProuct1 = view.findViewById<TextView>(R.id.title_product1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product1, parent, false)
        return Product1ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is Product1ViewHolder){
            holder.image1.setImageResource(item.image1)
            holder.titleProuct1.text = item.title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}