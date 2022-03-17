package com.mirkamol.demo_youtube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.demo_youtube.R
import com.mirkamol.demo_youtube.model.Filter

class FilterAdapter(var context: Context, var items: ArrayList<Filter>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var ITEM_EX = 0;
    var ITEM_FILTER = 1;

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return ITEM_EX
        }
        return ITEM_FILTER
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == ITEM_EX){
            return ExploreViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_explore, parent,false))
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter, parent, false)
        return FilterVideoHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filter = items[position]

        if (holder is FilterVideoHolder) {
            var tv_title = holder.tv_title
            tv_title.text = filter.title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class FilterVideoHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv_title: TextView

        init {
            tv_title = view.findViewById(R.id.tv_title)
        }
    }

    inner class ExploreViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }


}