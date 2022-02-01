package com.mirkamol.nestedscrolviewandrecyclerview.adapter

import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.nestedscrolviewandrecyclerview.DetailsActivity
import com.mirkamol.nestedscrolviewandrecyclerview.MainActivity
import com.mirkamol.nestedscrolviewandrecyclerview.R
import com.mirkamol.nestedscrolviewandrecyclerview.model.Contact

class CustomAdapter(
    val contactsList: ArrayList<Contact>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val tv_name = view.findViewById<TextView>(R.id.tv_name)
        val tv_number = view.findViewById<TextView>(R.id.tv_number)
        val image = view.findViewById<ImageView>(R.id.image)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            Log.d(TAG, "onClickdawwadwa")
            listener.myContact(contactsList[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact = contactsList.get(position)
        if (holder is CustomViewHolder) {
            holder.tv_name.text = contact.name
            holder.tv_number.text = contact.number
            holder.image.setImageResource(contact.image)
        }
    }

    interface OnItemClickListener {
        fun myContact(myContact: Contact)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}