package com.mirkamol.demo_youtube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_youtube.R
import com.mirkamol.demo_youtube.model.Feed
import com.mirkamol.demo_youtube.model.Short
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class FeedAdapter(var context: Context, var videos: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var TYPE_ITEM_VIEW = 0
    var TYPE_ITEM_SHORT = 1


    override fun getItemViewType(position: Int): Int {
        if (position == 1) {
            return TYPE_ITEM_SHORT
        }
        return TYPE_ITEM_VIEW
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_SHORT) {
            var view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_custom_short, parent, false)
            return FeedShortViewHolder(view)
        }

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_videos, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val video = videos[position]
        if (holder is FeedViewHolder) {

            Glide.with(context).load(video.profile).into(holder.iv_profile)

            holder.iv_video.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(video.videoYoutubeID, 0f)
                }
            })

        }

        if (holder is FeedShortViewHolder) {
            val recyclerView: RecyclerView = holder.recyclerView
            recyclerView.layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL, false
            )

            val shorts = getAllShorts()
            val adapter = ShortAdapter(shorts)
            recyclerView.adapter = adapter
        }
    }

    private fun getAllShorts(): ArrayList<Short> {
        val shorts = ArrayList<Short>()

        shorts.add(Short("https://youtu.be/NQgUrVzm1XI", "Muhammadali", "12K"))
        shorts.add(Short("https://youtu.be/NQgUrVzm1XI", "Muhammadali", "12K"))
        shorts.add(Short("https://youtu.be/NQgUrVzm1XI", "Muhammadali", "12K"))
        shorts.add(Short("https://youtu.be/NQgUrVzm1XI", "Muhammadali", "12K"))
        shorts.add(Short("https://youtu.be/NQgUrVzm1XI", "Muhammadali", "12K"))
        shorts.add(Short("https://youtu.be/NQgUrVzm1XI", "Muhammadali", "12K"))

        return shorts

    }


    override fun getItemCount(): Int {
        return videos.size
    }

    inner class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        val iv_video: YouTubePlayerView = view.findViewById(R.id.iv_video)


    }

    inner class FeedShortViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewShort)

    }
}