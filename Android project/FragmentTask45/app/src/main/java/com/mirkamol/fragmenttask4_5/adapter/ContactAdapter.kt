package com.example.fragmenttask5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttask5.R
import com.example.fragmenttask5.model.Contact

class ContactAdapter(private val contactList: ArrayList<Contact>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item_layout,parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact = contactList[position]

        if (holder is ContactViewHolder) {
            holder.apply {
                textName.text = contact.name
                textNumber.text = contact.number
            }
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    class ContactViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textName: TextView = view.findViewById(R.id.text_name_contact)
        val textNumber: TextView = view.findViewById(R.id.text_number_contact)
    }
}