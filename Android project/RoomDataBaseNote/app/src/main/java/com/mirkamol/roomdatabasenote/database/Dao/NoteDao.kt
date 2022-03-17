package com.mirkamol.roomdatabasenote.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mirkamol.roomdatabasenote.database.entity.Note

@Dao
interface NoteDao {
    @Insert
    fun insertNote(note:Note)
    @Query("SELECT * FROM note")
    fun getAllNote():List<Note>

}