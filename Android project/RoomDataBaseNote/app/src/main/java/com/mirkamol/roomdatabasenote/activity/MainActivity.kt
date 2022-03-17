package com.mirkamol.roomdatabasenote.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mirkamol.roomdatabasenote.R
import com.mirkamol.roomdatabasenote.adapter.NoteAdapter
import com.mirkamol.roomdatabasenote.database.AppDatabase
import com.mirkamol.roomdatabasenote.database.entity.Note

class MainActivity : AppCompatActivity(), Dialog.OnItemClicked {
    lateinit var recyclerView: RecyclerView
    lateinit var fabAddConfirm: FloatingActionButton
    lateinit var fabAdd: FloatingActionButton
    lateinit var noteAdapter: NoteAdapter
    lateinit var appDatabase: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appDatabase = AppDatabase.getInstance(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        noteAdapter = NoteAdapter(appDatabase.noteDao().getAllNote() as ArrayList<Note>)
        recyclerView.adapter = noteAdapter

        fabAdd = findViewById(R.id.fab_add)
        fabAddConfirm = findViewById(R.id.fab_add_left)

        fabAddConfirm.setOnClickListener {
            Dialog(this, this).openNewNotedialogConfirm()
        }
        fabAdd.setOnClickListener {
            Dialog(this, this).openNewNotedialog()
        }


    }

    override fun onDialogClicked(title: String, body: String) {
        appDatabase.noteDao().insertNote(Note(null, title, body))
        noteAdapter = NoteAdapter(appDatabase.noteDao().getAllNote() as ArrayList<Note>)
        recyclerView.adapter = noteAdapter
    }
}