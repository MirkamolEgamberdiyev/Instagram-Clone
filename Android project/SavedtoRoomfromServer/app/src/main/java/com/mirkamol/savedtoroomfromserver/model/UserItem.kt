package com.mirkamol.savedtoroomfromserver.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserItem(
    @PrimaryKey
    val id: String,

    val image: String,
    val name: String,
    val phone: Int
)