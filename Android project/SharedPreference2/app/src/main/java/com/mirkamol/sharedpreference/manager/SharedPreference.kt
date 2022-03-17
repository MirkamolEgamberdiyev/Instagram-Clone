package com.mirkamol.sharedpreference.manager

import android.content.Context
class SharedPreference(context: Context) {
    private var key1 = "key1"
    private var key2 = "key2"
    private var key3 = "key3"
    private var key4 = "key4"
    private var key5 = "key5"
    private var sharedPreference = context.getSharedPreferences("box", Context.MODE_PRIVATE)

    fun getString(): String? {
        return sharedPreference.getString(key1, "I love Android")
    }

    fun getLong():Long{
        return sharedPreference.getLong(key2, 1)
    }
    fun getBoolean():Boolean{
        return sharedPreference.getBoolean(key3, false)
    }

    fun getFloat():Float{
        return sharedPreference.getFloat(key4, 1.2F)
    }

    fun getInt():Int{
        return sharedPreference.getInt(key5, 3)
    }

    fun setString(text:String) {
        val editor = sharedPreference.edit()
        editor.putString(key1, "String value")
        editor.apply()
    }
    fun setLong(text:Long) {
        val editor = sharedPreference.edit()
        editor.putLong(key2, 10L)
        editor.apply()
    }
    fun setFloat(text:Float) {
        val editor = sharedPreference.edit()
        editor.putFloat(key4, 20F)
        editor.apply()
    }
    fun setBoolean(text:Boolean) {
        val editor = sharedPreference.edit()
        editor.putBoolean(key3,true)
        editor.apply()
    }
    fun setInt(text:Int) {
        val editor = sharedPreference.edit()
        editor.putInt(key5, 30)
        editor.apply()
    }










}