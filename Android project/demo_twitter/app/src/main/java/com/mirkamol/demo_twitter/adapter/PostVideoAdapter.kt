package com.mirkamol.demo_twitter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_twitter.R
import com.mirkamol.demo_twitter.model.PostVideo
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class PostVideoAdapter(val videos: ArrayList<PostVideo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class PostVideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var yt_video: YouTubePlayerView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            yt_video = view.findViewById(R.id.yt_video)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)

        return PostVideoViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val video = videos[position]
        if (holder is PostVideoViewHolder) {
            holder.iv_profile.setImageResource(video.profile)
            holder.tv_fullname.text = video.fullname

            holder.yt_video.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(video.youtubeVideo, 0f)
                    youTubePlayer.pause()

                }
            })
        }
    }

    override fun getItemCount(): Int {
        return videos.size
    }
}