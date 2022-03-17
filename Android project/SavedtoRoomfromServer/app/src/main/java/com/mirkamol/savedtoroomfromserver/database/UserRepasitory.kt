package com.mirkamol.savedtoroomfromserver.database

import android.app.Application
import com.mirkamol.savedtoroomfromserver.helper.Logger
import com.mirkamol.savedtoroomfromserver.manager.RoomManager
import com.mirkamol.savedtoroomfromserver.model.UserItem

class UserRepasitory(application: Application) {
    val TAG:String = UserRepasitory::class.java.simpleName

    private val db = RoomManager.getDatabase(application)
    private val userDao:UserDao = db!!.userDao()

    fun getUsers():List<UserItem>{
        Logger.d(TAG, "Done")

        return userDao.getUsers()
    }

    fun saveUser(userDB: UserItem){
        Logger.d(TAG, "Saved")
        userDao.saveUser(userDB)
    }

    fun deleteUsers(){
        Logger.d(TAG, "Database cleared")

        userDao.deleteAllUsers()
    }
}
