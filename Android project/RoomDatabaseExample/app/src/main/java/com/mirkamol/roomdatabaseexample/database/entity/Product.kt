package com.mirkamol.roomdatabaseexample.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "table_name")
data class Product(
    @PrimaryKey(autoGenerate = true)
    var productId:Int? = null,
    var name:String,
    var price:Int
    )
