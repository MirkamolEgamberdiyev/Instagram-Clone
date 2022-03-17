package com.mirkamol.roomdatabasewithnetworking.database.dao

import android.service.quicksettings.Tile
import androidx.room.*
import androidx.room.Dao
import com.mirkamol.roomdatabasewithnetworking.database.entity.Post

@Dao
interface Dao {
    @Insert()
    fun createPost(post: Post)
    @Query("SELECT * FROM posts")
    fun getPosts():List<Post>

    @Query("SELECT * FROM posts WHERE id = :id")
    fun getPhoto(id:Int):Post

    @Query("DELETE FROM posts")
    fun clearPosts()

    @Delete()
    fun deletePostwithDelete(post: Post)

    @Query("DELETE FROM posts WHERE id = :id")
    fun deletePost(id: Int)

    @Update
    fun updateWithUpdate(post: Post)

    @Query("UPDATE posts SET title =:title WHERE id =:id")
    fun updatePost(title: String, id: Int)



}