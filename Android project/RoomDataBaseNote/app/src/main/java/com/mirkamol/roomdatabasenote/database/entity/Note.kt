package com.mirkamol.roomdatabasenote.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var noteTitle: String,
    var noteBody:String
)