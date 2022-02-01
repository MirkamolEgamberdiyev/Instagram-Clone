package com.mirkamol.fragmentbyrecyclerview.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.fragmentbyrecyclerview.R
import com.mirkamol.fragmentbyrecyclerview.model.Contact
import org.w3c.dom.Text

class ContactAdapter(private val contacts: ArrayList<Contact>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_contact_image:ImageView = view.findViewById(R.id.ic_image)
        val tv_contact_name :TextView= view.findViewById(R.id.tv_name)
        val tv_contact_number:TextView = view.findViewById(R.id.phoneNumber)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact_layout, parent, false)
        return ContactViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      val contact =contacts[position]
        if (holder is ContactViewHolder){
            holder.tv_contact_image.setImageResource(contact.image)
            holder.tv_contact_name.setText(contact.name)
            holder.tv_contact_number.setText(contact.number)
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}