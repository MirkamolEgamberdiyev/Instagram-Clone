package com.mirkamol.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceExample(context: Context) {
    val sharedrefrence = context.getSharedPreferences("mypref", Context.MODE_PRIVATE)

    companion object{
      private const val  key = "key"
    }

    @SuppressLint("CommitPrefEdits")
    fun setLoggedIn(longValue: Long) {
        val editor= sharedrefrence.edit()
        editor.putString(key, longValue.toString())
    }

    fun getLoggedIn(context: Context): Long {
        return sharedrefrence.getLong(context.getString(R.string.longValue), 1L)
    }
}