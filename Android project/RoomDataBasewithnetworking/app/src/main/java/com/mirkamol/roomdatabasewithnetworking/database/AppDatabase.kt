package com.mirkamol.roomdatabasewithnetworking.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mirkamol.roomdatabasewithnetworking.database.dao.Dao
import com.mirkamol.roomdatabasewithnetworking.database.entity.Post

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun PostDao(): Dao
    companion object{
        private var instance:AppDatabase? = null
        @Synchronized
        fun getInstance(context: Context):AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "post.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

            }
            return instance!!
        }
    }
}