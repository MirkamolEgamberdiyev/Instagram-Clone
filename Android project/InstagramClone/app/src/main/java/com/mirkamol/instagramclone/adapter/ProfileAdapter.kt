package com.mirkamol.instagramclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.instagramclone.R
import com.mirkamol.instagramclone.fragment.ProfileFragment
import com.mirkamol.instagramclone.model.Post
import com.mirkamol.instagramclone.utils.Utils

class ProfileAdapter(var fragment: ProfileFragment, var items:ArrayList<Post>):BaseAdapter() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_profile, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = items[position]
        if (holder is ProfileViewHolder){
            var ivPost = holder.ivPost
            setViewHeight(ivPost)
            Glide.with(fragment).load(post.image).into(ivPost)
        }
    }

    class ProfileViewHolder(var view:View):RecyclerView.ViewHolder(view){
        var ivPost:ShapeableImageView
        var tvCaption:TextView

        init {
            ivPost = view.findViewById(R.id.iv_post)
            tvCaption = view.findViewById<TextView>(R.id.tv_caption)
        }
    }

    /**
     * Set ShapeableImageView height as screen  width
     */
    private fun setViewHeight(view:View){
        val params:ViewGroup.LayoutParams = view.layoutParams
        params.height = Utils.screenSize(fragment.requireActivity().application).width/2
        view.layoutParams = params
    }



}