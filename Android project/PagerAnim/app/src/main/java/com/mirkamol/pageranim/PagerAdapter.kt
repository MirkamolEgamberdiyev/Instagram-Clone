package com.mirkamol.pageranim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class PagerAdapter : RecyclerView.Adapter<PagerAdapter.VH>() {

    private val dif = AsyncListDiffer(this, ITEM_DIF)

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {

        var img = view.findViewById<ImageView>(R.id.img_bg)
        var title = view.findViewById<TextView>(R.id.tv_title)
        fun bind() {
            var pager = dif.currentList[adapterPosition]
            img.setImageResource(pager.img)
            title.text = pager.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.pager_item, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()

    override fun getItemCount(): Int = dif.currentList.size


    fun submitList(list: List<Pager>) {
        dif.submitList(list)
    }

    companion object {
        private val ITEM_DIF = object : DiffUtil.ItemCallback<Pager>() {
            override fun areItemsTheSame(oldItem: Pager, newItem: Pager): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Pager, newItem: Pager): Boolean =
                oldItem.title == newItem.title

        }
    }


}