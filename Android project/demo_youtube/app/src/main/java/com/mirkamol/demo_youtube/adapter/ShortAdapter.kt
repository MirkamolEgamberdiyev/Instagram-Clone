package com.mirkamol.demo_youtube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirkamol.demo_youtube.R
import com.mirkamol.demo_youtube.model.Short
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class ShortAdapter(val items: ArrayList<Short>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ShortVideoHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shortVideos = view.findViewById<YouTubePlayerView>(R.id.short_video)
        val title = view.findViewById<TextView>(R.id.tv_title)
        val viewCount = view.findViewById<TextView>(R.id.viewCount)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_short_videos, parent, false)
        return ShortVideoHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is ShortVideoHolder) {
            holder.title.text = item.title
            holder.viewCount.text = item.viewCount

            holder.shortVideos.addYouTubePlayerListener(object :AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(item.shortVideos, 0f)
                }
            })

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}