package com.wonmirzo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.unicornexam.R
import com.wonmirzo.listener.OnBottomPageListener
import com.wonmirzo.model.IntroItem

class IntroPageAdapter(
    var context: Context,
    private var items: ArrayList<IntroItem>,
    private var listener: OnBottomPageListener
) :
    RecyclerView.Adapter<IntroPageAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_intro_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        if (position == items.size - 1){
            listener.onBottomReached(position)
        }

        val ivIcon = holder.ivIcon
        val tvTitle = holder.tvTitle
        val tvDescription = holder.tvDescription

        ivIcon.setImageResource(item.icon)
        tvTitle.text = item.title
        tvDescription.text = item.description
    }

    override fun getItemCount(): Int = items.size

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivIcon: ImageView = view.findViewById(R.id.ivIcon)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
    }

}