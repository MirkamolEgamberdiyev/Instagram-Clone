package com.mirkamol.demo_instagram.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.demo_instagram.R
import com.mirkamol.demo_instagram.model.Feed
import com.mirkamol.demo_instagram.model.Post
import com.mirkamol.demo_instagram.model.Story
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private val TYPE_ITEM_STORY = 0
        private val TYPE_ITEM_POST = 1
        private const val TYPE_PHOTOS_POST_VIEW = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            items[position].stories.size > 0 -> {
                TYPE_ITEM_STORY
            }
            items[position].post!!.photos.isNotEmpty() -> {
                TYPE_PHOTOS_POST_VIEW
            }
            else -> {
                TYPE_ITEM_POST
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_STORY) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(context, view)
        } else if (viewType == TYPE_PHOTOS_POST_VIEW) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_feed_post_photos, parent, false)
            return PhotosPostViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return PosterViewHolder(view)
    }


    fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context, stories)
        val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]
        if (holder is StoryViewHolder) {
            var recyclerView = holder.recyclerView
            refreshAdapter(feed.stories, recyclerView)
        }

        if (holder is PosterViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_photo = holder.iv_photo
            var tv_fullname = holder.tv_fullname

            Glide.with(context).load(feed.post!!.profile).into(iv_profile)
            Glide.with(context).load(feed.post!!.photo).into(iv_photo)
            tv_fullname.text = feed.post!!.fullName

            //  iv_profile.setImageResource(feed.post!!.profile)
            //  iv_photo.setImageResource(feed.post!!.photo)
        }

        if (holder is PhotosPostViewHolder) {
            val post: Post = feed.post!!
            //    holder.iv_profile.setImageResource(post.profile)

            Glide.with(context).load(post.profile).into(holder.iv_profile)

            val adapter = ViewPagerAdapter(context, post.photos)
            holder.vp_photo.adapter = adapter
            holder.wormDotsIndicator.setViewPager(holder.vp_photo)
            holder.tv_fullName.text = post.fullName



            holder.vp_photo.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                }

                @SuppressLint("SetTextI18n")
                override fun onPageSelected(position: Int) {
                    holder.tv_first.text = (position + 1).toString()+"/"+post.photos.size
                }

                override fun onPageScrollStateChanged(state: Int) {

                }
            })
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
        }
    }

    class PosterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ImageView
        var iv_photo: ImageView
        var iv_like: ImageView
        var iv_comment: ImageView
        var iv_send: ImageView
        var iv_save: ImageView
        var tv_fullname: TextView
        var tv_caption: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
            iv_like = view.findViewById(R.id.iv_like)
            iv_comment = view.findViewById(R.id.iv_comment)
            iv_send = view.findViewById(R.id.iv_send)
            iv_save = view.findViewById(R.id.iv_save)
            iv_photo = view.findViewById(R.id.iv_photo)
            tv_caption = view.findViewById(R.id.tv_caption)
        }
    }


    private class PhotosPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tv_fullName: TextView = view.findViewById(R.id.tv_full_name)
        var vp_photo: ViewPager = view.findViewById(R.id.view_pager)
        var wormDotsIndicator: WormDotsIndicator = view.findViewById(R.id.worm_dot)
        val tv_first = view.findViewById<TextView>(R.id.counterTextView)
        val imageView = view.findViewById<ImageView>(R.id.iv_photo)

    }
}