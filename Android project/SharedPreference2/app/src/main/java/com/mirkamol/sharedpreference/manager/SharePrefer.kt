package com.mirkamol.sharedpreference.manager
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.mirkamol.sharedpreference.model.User

class SharePrefer(context: Context) {

    private var sharedPreference = context.getSharedPreferences("box", Context.MODE_PRIVATE)
    val gson = Gson()

    companion object {
        private const val KEY_NAME = "name"
        private const val KEY_EMAIL = "email"
        private val USER = "user"
    }


    fun getUser(key: String):User{
        val gsonUser = sharedPreference.getString(USER, "")

        return gson.fromJson(gsonUser, User::class.java)
    }

    fun saveUser(key: String, objects: Any) {
        val toJsonUser = gson.toJson(objects)
        sharedPreference.edit().putString(key, toJsonUser).apply()
    }


    var isSaved: Boolean
        get() = sharedPreference.getBoolean("isSaved", false)

        set(value) = sharedPreference.edit {
            this.putBoolean("isSaved", value)
        }

    fun getName(): String? {
        return sharedPreference.getString(KEY_NAME, "Mirakmol")
    }

    fun setName(name: String) {
        val editor = sharedPreference.edit()
        editor.putString(KEY_NAME, name)
        editor.apply()
    }

    fun getEmail(): String? {
        return sharedPreference.getString(KEY_EMAIL, "email@gmail.com")
    }

    fun setEmail(email: String) {
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString(KEY_EMAIL, email)
        editor.apply()
    }


    fun get(key: String): Any {
        if (sharedPreference.contains(key)) {
            sharedPreference.all.entries.forEach {
                if (it.key == key) {
                    return it.value!!
                }
            }
        }
        return 0
    }
}