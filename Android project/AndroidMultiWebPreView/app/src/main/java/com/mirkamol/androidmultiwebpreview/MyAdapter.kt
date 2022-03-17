package com.mirkamol.androidmultiwebpreview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindInt
import butterknife.BindView
import butterknife.Unbinder
import com.google.android.material.progressindicator.CircularProgressIndicator

class MyAdapter(context: Context, val urlList: List<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        lateinit var unbinder: Unbinder

        @BindView(R.id.img_preview)
        lateinit var imageView: ImageView

        @BindView(R.id.txt_title)
        lateinit var txt_title: TextView

        @BindView(R.id.txt_description)
        lateinit var txt_description: TextView

        @BindView(R.id.layout_preview)
        lateinit var layout_preview: LinearLayout

        @BindView(R.id.progress_bar)
        lateinit var progress_bar: CircularProgressIndicator

        @BindView(R.id.card_view)
        lateinit var card_view: CardView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_preview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return urlList.size
    }
}