package com.example.fragmenttask5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttask5.R
import com.example.fragmenttask5.model.Post

class PostAdapter(private var postList: ArrayList<Post>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item_layout,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = postList[position]
        if (holder is PostViewHolder){
            holder.apply {
                textName.text = post.title
                textDescription.text = post.description
                image.setImageResource(R.drawable.img_sample_post)
            }
        }
    }

    override fun getItemCount(): Int {
      return  postList.size
    }

    class PostViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textName:TextView = view.findViewById(R.id.text_name_post)
        val textDescription: TextView = view.findViewById(R.id.text_description_post)
        val image:ImageView = view.findViewById(R.id.imv_post)
    }
}