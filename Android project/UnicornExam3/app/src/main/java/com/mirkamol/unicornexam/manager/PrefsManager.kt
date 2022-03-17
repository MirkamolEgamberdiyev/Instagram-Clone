

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PrefsManager(context: Context) {
    private val sharedPreferences: SharedPreferences? =
        context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    var isSaved: Boolean
        get() = sharedPreferences!!.getBoolean("isSaved", false)
        set(value) = sharedPreferences!!.edit {
            this.putBoolean("isSaved", value)
        }

    companion object {
        private var prefsManager: PrefsManager? = null
        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager
        }
    }

    fun saveData(key: String?, value: String?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }


    fun getData(key: String?): String? {
        return if (sharedPreferences != null) sharedPreferences.getString(key, "") else "en"
    }
}