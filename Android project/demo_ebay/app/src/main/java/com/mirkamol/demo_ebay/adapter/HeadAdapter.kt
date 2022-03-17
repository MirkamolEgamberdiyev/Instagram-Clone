package com.mirkamol.demo_ebay.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.demo_ebay.R
import com.mirkamol.demo_ebay.model.Head

class HeadAdapter(val items:ArrayList<Head>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class CustomHeadViewHolder(view: View):RecyclerView.ViewHolder(view){
        val headImage = view.findViewById<ImageView>(R.id.image_head)
        val title = view.findViewById<TextView>(R.id.title)
        val cost = view.findViewById<TextView>(R.id.cost)
        val discount = view.findViewById<TextView>(R.id.discount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_deal_shipping, parent, false)
       return CustomHeadViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val item = items[position]

        if (holder is CustomHeadViewHolder){
            holder.headImage.setImageResource(item.image_head)
            holder.title.text = item.title
            holder.cost.text = item.cost
            holder.discount.text = item.discount
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}