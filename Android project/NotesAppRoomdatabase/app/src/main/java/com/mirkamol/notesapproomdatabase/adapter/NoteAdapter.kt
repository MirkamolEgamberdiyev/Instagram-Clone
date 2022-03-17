package com.mirkamol.notesapproomdatabase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.notesapproomdatabase.R
import com.mirkamol.notesapproomdatabase.database.entity.Note

class NoteAdapter(private val list: ArrayList<Note>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewDate = view.findViewById<TextView>(R.id.text_view_date)
        val textViewNoteTitle = view.findViewById<TextView>(R.id.text_view_note_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val note = list[position]
        if (holder is NoteViewHolder) {
            holder.textViewDate.text = note.currentDate
            holder.textViewNoteTitle.text = note.noteTitle
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}