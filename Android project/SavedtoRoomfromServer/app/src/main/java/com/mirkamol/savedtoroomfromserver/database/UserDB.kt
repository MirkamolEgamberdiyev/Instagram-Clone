package com.mirkamol.savedtoroomfromserver.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDB(
    @PrimaryKey
    val id: String,

    val image: String,
    val name: String,
    val phone: Int
)