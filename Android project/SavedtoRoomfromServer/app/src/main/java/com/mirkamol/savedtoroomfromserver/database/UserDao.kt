package com.mirkamol.savedtoroomfromserver.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mirkamol.savedtoroomfromserver.model.UserItem

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(userDB: UserItem)

    @Query("SELECT *FROM user")
    fun getUsers():List<UserItem>

    @Query("DELETE FROM user")
    fun deleteAllUsers()
}