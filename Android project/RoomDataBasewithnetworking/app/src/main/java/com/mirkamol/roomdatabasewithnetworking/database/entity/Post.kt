package com.mirkamol.roomdatabasewithnetworking.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var title:String,
    var body:String
)
