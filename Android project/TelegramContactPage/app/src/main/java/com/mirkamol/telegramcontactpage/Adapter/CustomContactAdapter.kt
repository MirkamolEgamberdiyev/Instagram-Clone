package com.mirkamol.telegramcontactpage.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.telegramcontactpage.R
import com.mirkamol.telegramcontactpage.model.Contact

class CustomContactAdapter(val context: Context, val contacts: ArrayList<Contact>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contacts, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val contact = contacts[position]
        if (holder is CustomViewHolder){
            holder.ic_profile.setImageResource(contact.profile)
            holder.name.text = contact.name
            holder.last_time.text = contact.last_time
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class CustomViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ic_profile = view.findViewById<ShapeableImageView>(R.id.ic_profile)
        val name = view.findViewById<TextView>(R.id.tv_name)
        val last_time = view.findViewById<TextView>(R.id.tv_last_time)
    }


}