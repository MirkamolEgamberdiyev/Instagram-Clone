package com.mirkamol.savedtoroomfromserver.manager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mirkamol.savedtoroomfromserver.database.UserDao
import com.mirkamol.savedtoroomfromserver.model.UserItem

@Database(entities = [UserItem::class], version = 1)
abstract class RoomManager:RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        private var INSTANCE:RoomManager? = null

        fun getDatabase(context: Context):RoomManager?{
            if (INSTANCE == null){
                synchronized(RoomManager::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, RoomManager::class.java, "users.db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }

}