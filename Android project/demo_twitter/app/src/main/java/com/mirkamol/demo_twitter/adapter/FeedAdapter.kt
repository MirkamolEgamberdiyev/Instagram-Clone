package com.mirkamol.demo_twitter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_twitter.R
import com.mirkamol.demo_twitter.model.Post
import com.mirkamol.demo_twitter.model.PostDouble
import com.mirkamol.demo_twitter.model.PostVideo

class FeedAdapter(var context: Context, var items: ArrayList<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var TYPE_FEED_POST = 0
    var TYPE_FEED_POST2 = 1
    var TYPE_VIDEO = 2

    override fun getItemViewType(position: Int): Int {
        if (position == 0 || position == 5 || position == 10) {
            return TYPE_FEED_POST2
        } else if (position == 3 || position == 5 || position == 7) {
            return TYPE_FEED_POST
        }
        return TYPE_VIDEO

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_FEED_POST2) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_cutom_post, parent, false)
            return PostViewHolder(view)

        } else if (viewType == TYPE_FEED_POST) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
            return FeedViewHolder(view)

        }

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_custom_video, parent, false)
        return PostVideoViewHolder(view)


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]
        if (holder is FeedViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_post = holder.iv_post
            var tv_fullname = holder.tv_fullname


            iv_profile.setImageResource(feed.profile)
            iv_post.setImageResource(feed.photo)
            tv_fullname.text = feed.fullname
        }

        if (holder is PostViewHolder) {
            val recyclerView: RecyclerView = holder.recyclerView

            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


            val posts = getAllPosts()
            val adapter = PostAdapter(posts)
            recyclerView.adapter = adapter


        }



        if (holder is PostVideoViewHolder) {
            val recyclerView: RecyclerView = holder.recyclerView

            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            val videos = getAllVideos()
            val adapter = PostVideoAdapter(videos)
            recyclerView.adapter = adapter
        }
    }

    private fun getAllVideos(): ArrayList<PostVideo> {
        val videos = ArrayList<PostVideo>()
        videos.add(PostVideo(R.drawable.user, "Mirkamol Egamberdiyev", "yi0OYUMqvAw"))
        return videos

    }

    private fun getAllPosts(): ArrayList<PostDouble> {
        val posts = ArrayList<PostDouble>()
        posts.add(
            PostDouble(
                R.drawable.user,
                "Mirkamol Egamberdiyev",
                R.drawable.post_2,
                R.drawable.post_2
            )
        )
        posts.add(
            PostDouble(
                R.drawable.user,
                "Mirkamol Egamberdiyev",
                R.drawable.post_2,
                R.drawable.post_2
            )
        )
        return posts
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_post: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_post = view.findViewById(R.id.iv_post)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerPost)
    }

    inner class PostVideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewVideo)

    }


}