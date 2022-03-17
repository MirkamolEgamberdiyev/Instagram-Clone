package com.mirkamol.retrofitexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.retrofitexample.R
import com.mirkamol.retrofitexample.model.Sponsor
import com.squareup.picasso.Picasso
import java.lang.Exception

class PhotosAdapter(var photos: ArrayList<Sponsor>) :
    RecyclerView.Adapter<PhotosAdapter.HomePhotoVH>() {

    lateinit var photoClick: ((Sponsor) -> Unit)

    inner class HomePhotoVH(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(photo: Sponsor) {
            val ivHomePhoto: ImageView = view.findViewById(R.id.photo_iv)

            ivHomePhoto.setOnClickListener {
                photoClick.invoke(photo)
            }



            Picasso.get()
                .load(photo.urls.regular)
                .into(ivHomePhoto, object : com.squareup.picasso.Callback {
                    override fun onSuccess() {
                        if (photo.alt_description != null) {

                        }
                    }
                    override fun onError(e: Exception?) {

                    }
                })
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePhotoVH {
        return HomePhotoVH(
            LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomePhotoVH, position: Int) {
        holder.bind(getItem(position))

    }

    private fun getItem(position: Int): Sponsor = photos[position]

    override fun getItemCount(): Int = photos.size
}
