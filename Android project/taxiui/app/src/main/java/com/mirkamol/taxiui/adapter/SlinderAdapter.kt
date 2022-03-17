package com.mirkamol.taxiui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.taxiui.model.Banner
import com.mirkamol.taxiui.R
import com.squareup.picasso.Picasso

class SlinderAdapter:RecyclerView.Adapter<SlinderAdapter.SlinderViewHolder>() {

   private val slinderItem:ArrayList<Banner> = ArrayList()

    inner class SlinderViewHolder(var view:View):RecyclerView.ViewHolder(view){
        val banner = slinderItem[adapterPosition]
        fun bind(){
            var title  = view.findViewById<TextView>(R.id.title)
            var image = view.findViewById<ImageView>(R.id.image)

            title.text = banner.title

            Picasso.get().load(banner.image).into(image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlinderViewHolder {
        return SlinderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.slinder_item, parent, false))
    }

    override fun onBindViewHolder(holder: SlinderViewHolder, position: Int)  = holder.bind()
    override fun getItemCount(): Int  = slinderItem.size


    fun submitData(list: List<Banner>){
        slinderItem.addAll(list)
        notifyDataSetChanged()

    }

}