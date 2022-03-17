package com.mirkamol.notesapproomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mirkamol.notesapproomdatabase.adapter.NoteAdapter
import com.mirkamol.notesapproomdatabase.database.AppDatabase
import com.mirkamol.notesapproomdatabase.database.entity.Note
import com.mirkamol.notesapproomdatabase.database.entity.ViewDialog

class MainActivity : AppCompatActivity(), ViewDialog.OnItemClicked {
    lateinit var recyclerView: RecyclerView
    lateinit var fabAdd: FloatingActionButton
    lateinit var noteAdapter: NoteAdapter
    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appDatabase = AppDatabase.getInstance(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        noteAdapter =  NoteAdapter( appDatabase.noteDao().getAllNote() as ArrayList<Note>)
        recyclerView.adapter = noteAdapter
        fabAdd = findViewById(R.id.fab_add)
        fabAdd.setOnClickListener {
            ViewDialog(this, this).openNewNoteDialog()
        }
    }

    override fun onDialogClicked(title: String, currentDate: String) {
        appDatabase.noteDao().insertNote(Note(null,currentDate, title))
        noteAdapter =  NoteAdapter( appDatabase.noteDao().getAllNote() as ArrayList<Note>)
        recyclerView.adapter = noteAdapter

    }
}