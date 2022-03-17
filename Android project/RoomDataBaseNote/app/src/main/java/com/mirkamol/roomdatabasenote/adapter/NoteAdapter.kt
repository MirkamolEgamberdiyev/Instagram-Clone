package com.mirkamol.roomdatabasenote.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.roomdatabasenote.R
import com.mirkamol.roomdatabasenote.database.entity.Note

class NoteAdapter(private val list: ArrayList<Note>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNoteTitle = view.findViewById<TextView>(R.id.text_view_note_title)
        val text_view_date = view.findViewById<TextView>(R.id.text_view_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val note = list[position]
        if (holder is NoteViewHolder) {
            holder.textViewNoteTitle.text = note.noteTitle
            holder.text_view_date.text = note.noteBody
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}