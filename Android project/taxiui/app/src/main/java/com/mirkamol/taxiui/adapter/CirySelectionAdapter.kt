package com.mirkamol.taxiui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.taxiui.R
import com.mirkamol.taxiui.model.Region

class CirySelectionAdapter : RecyclerView.Adapter<CirySelectionAdapter.ViewHolder>() {

    private val regiomItems: ArrayList<Region> = ArrayList()
    lateinit var itemclick: ((Region) -> Unit)

    inner class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val region = regiomItems[adapterPosition]
        fun bind() {
            var title = view.findViewById<TextView>(R.id.name)
            var root = view.findViewById<LinearLayout>(R.id.ll_root)
            title.text = region.title

            root.setOnClickListener {
                itemclick.invoke(region)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_city_selection, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()
    override fun getItemCount(): Int = regiomItems.size


    fun submitData(list: List<Region>) {
        regiomItems.addAll(list)
        notifyDataSetChanged()

    }

}
