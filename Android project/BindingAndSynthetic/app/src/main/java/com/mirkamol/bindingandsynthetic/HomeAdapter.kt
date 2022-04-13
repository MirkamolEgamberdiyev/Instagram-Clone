package com.mirkamol.bindingandsynthetic

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.bindingandsynthetic.databinding.HomeItemBinding

class HomeAdapter(val context: Context) : RecyclerView.Adapter<HomeAdapter.VH>() {
    val list = IntArray(10)



    inner class VH(val binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                btnDegre.setOnClickListener {
                    list[adapterPosition]--
                    texts.text = list[adapterPosition].toString()

                }



                btnAdd.setOnClickListener {
                    list[adapterPosition]++
                    texts.text = list[adapterPosition].toString()
                }

                btnSend.setOnClickListener {
                    Toast.makeText(context,   texts.text.toString(), Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()
    override fun getItemCount(): Int {
        return 10
    }
}