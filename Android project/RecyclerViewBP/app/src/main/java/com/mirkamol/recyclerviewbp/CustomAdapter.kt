package com.mirkamol.recyclerviewbp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.recyclerviewbp.model.Contact

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.VH>() {
    private val dif = AsyncListDiffer(this, ITEM_DIFF)

    companion object {
        private val ITEM_DIFF = object : DiffUtil.ItemCallback<Contact>() {
            override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean =
                oldItem.name == newItem.name && oldItem.numaber == newItem.numaber



            override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean =
                oldItem.name == newItem.name && oldItem.numaber == newItem.numaber


        }
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val name  = view.findViewById<TextView>(R.id.name)
        val number = view.findViewById<TextView>(R.id.number)

        fun bind() {

            val contact = dif.currentList[adapterPosition]
            name.text = contact.name
            number.text = contact.numaber
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()

    override fun getItemCount(): Int {
        return dif.currentList.size
    }

    fun submitList(list:List<Contact>){
        dif.submitList(list)
    }
}