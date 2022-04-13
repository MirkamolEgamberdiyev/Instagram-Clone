package com.mirkamol.instagramclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.instagramclone.R
import com.mirkamol.instagramclone.fragment.SearchFragment
import com.mirkamol.instagramclone.model.User

class SearchAdapter(var fragment: SearchFragment, var items:ArrayList<User>):BaseAdapter() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_search, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = items[position]

        if (holder is UserViewHolder){
            holder.tvFullname.text = user.fullname
            holder.tvEmail.text = user.email
        }
    }

    class UserViewHolder(var view:View):RecyclerView.ViewHolder(view){
        var iv_profile:ShapeableImageView
        var tvFullname:TextView
        var tvEmail:TextView
        var tvFollow:TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tvFullname = view.findViewById(R.id.tv_fullname)
            tvEmail = view.findViewById(R.id.tv_email)
            tvFollow = view.findViewById(R.id.tv_follow)
        }

    }
}