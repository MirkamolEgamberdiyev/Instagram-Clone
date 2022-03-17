package com.mirkamol.sharedpreference

import android.content.Context
import android.widget.Toast
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.map


class AppPref(context: Context) {
    private val dataStore = context.createDataStore("nimadur")

    companion object{
        val USER_AGE_KEY = preferencesKey<Int>("USER_AGE")
        val USER_NAME_KEY = preferencesKey<String>("USER_AGE")
    }

    suspend fun storeUser(age:Int, name:String){
        dataStore.edit {
            it[USER_AGE_KEY] = age
            it[USER_NAME_KEY] = name
        }
    }

    val userAge = dataStore.data.map {
        val age = it[USER_AGE_KEY]?:0
        if (age<18){
            Toast.makeText(context, "chekkaroqda o'ynab tur patsan", Toast.LENGTH_SHORT).show()
        }
         age
    }

    val userName = dataStore.data.map {
        it[USER_NAME_KEY]?: ""
    }

}