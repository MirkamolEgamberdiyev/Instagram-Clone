package com.mirkamol.apiexampleanddatabase.model

data class Post(
    val body: String,
    val id: Int? = null,
    val title: String,
    val userId: Int? = null
)