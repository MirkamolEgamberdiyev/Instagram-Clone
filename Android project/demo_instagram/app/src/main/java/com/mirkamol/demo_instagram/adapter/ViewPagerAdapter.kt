package com.mirkamol.demo_instagram.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.mirkamol.demo_instagram.R
import com.mirkamol.demo_instagram.model.Photos

class ViewPagerAdapter(var context: Context, var photos: List<Photos>) : PagerAdapter() {
    override fun getCount(): Int {
        return photos.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val photo: Photos = photos[position]
        val view = LayoutInflater.from(context.applicationContext)
            .inflate(R.layout.item_vp, container, false)

        val viewPager = container as ViewPager
        viewPager.addView(view, 0)
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }
}