package com.mirkamol.demo_amazon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.demo_amazon.R
import com.mirkamol.demo_amazon.model.Department

class DepartmentAdapter(val items: ArrayList<Department>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class DepartmentViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val beautyImage = view.findViewById<ImageView>(R.id.beauty_image)
        val name = view.findViewById<TextView>(R.id.beauty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_department, parent, false)
        return DepartmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val item = items[position]

        if (holder is DepartmentViewHolder){
            holder.beautyImage.setImageResource(item.beautyImage)
            holder.name.text = item.name

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}