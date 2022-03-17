package com.mirkamol.notesapproomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import com.mirkamol.notesapproomdatabase.database.entity.Note

@Dao
interface NoteDao {
    @Insert
    fun insertNote(note: Note)
    @Query("SELECT * FROM note")
    fun getAllNote():List<Note>

}
