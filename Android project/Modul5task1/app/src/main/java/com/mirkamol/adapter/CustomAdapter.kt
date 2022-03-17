package com.mirkamol.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.airbnb.lottie.LottieAnimationView
import com.mirkamol.model.Page
import com.mirkamol.modul5task1.R

class CustomAdapter(val list: List<String>,val pages:List<Page>, val context: Context) : PagerAdapter() {
//    lateinit var layoutInflater: LayoutInflater

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        layoutInflater = LayoutInflater.from(context)
//        val view = layoutInflater.inflate(R.layout.layout_viewpager_item, container, false)
        val view = LayoutInflater.from(context).inflate(R.layout.layout_viewpager_item, container, false)
        val animation = view.findViewById<LottieAnimationView>(R.id.lot_animation)
        val title = view.findViewById<TextView>(R.id.tv_title)
        val description = view.findViewById<TextView>(R.id.tv_description)
        animation.setAnimation(list.get(position))
        title.setText(pages.get(position).title)
        description.setText(pages.get(position).description)
        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}

