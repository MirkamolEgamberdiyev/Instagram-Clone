package com.mirkamol.preferenceexample.manager

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import android.preference.PreferenceManager
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.collections.LinkedHashSet
import kotlin.math.sign

class LocaleManager(context: Context?) {
    private val prefs: SharedPreferences

    val language: String?
        get() = prefs.getString(LANGUAGE_KEY, LANGUAGE_ENGLISH)

    fun setLocale(context: Context): Context {
        return update(context, language)
    }

    fun setNewLocale(context: Context, language: String?) {
        persistLanguage(language)
        update(context, language)
    }

    private fun persistLanguage(language: String?) {
        prefs.edit().putString(LANGUAGE_KEY, language).apply()

    }

    private fun update(context: Context, language: String?): Context {
        updateResources(context, language)

        val appContext = context.applicationContext
        if (context !== appContext) {
            updateResources(appContext, language)
        }
        return appContext
    }

    private fun updateResources(context: Context, language: String?) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val res = context.resources

        val config = Configuration(res.configuration)
        if (isAtLeastVersion(Build.VERSION_CODES.N)) {
            setLocaleForApi24(config, locale)
        } else if (isAtLeastVersion(Build.VERSION_CODES.JELLY_BEAN_MR1)) {
            config.setLocale(locale)
        } else {
            config.locale = locale
        }

        res.updateConfiguration(config, res.displayMetrics)

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setLocaleForApi24(config: Configuration, locale: Locale) {
        val set: MutableSet<Locale> = LinkedHashSet()

        set.add(locale)
        val all = LocaleList.getDefault()
        for (i in 0 until all.size()) {
            set.add(all[i])
        }
        val locales = set.toTypedArray()
        config.setLocales(LocaleList(*locales))
    }


    companion object {
        const val LANGUAGE_ENGLISH = "en"
        const val LANGUAGE_JAPAN = "ja"
        const val LANGUAGE_KOREAN = "ko"
        const val LANGUAGE_UZBEK = "uz"
        private const val LANGUAGE_KEY = "language_key"


        fun getLocale(res: Resources): Locale {
            val config = res.configuration
            return if (isAtLeastVersion(Build.VERSION_CODES.N)) config.locales[0] else config.locale
        }

        fun isAtLeastVersion(version: Int): Boolean {
            return Build.VERSION.SDK_INT >= version
        }
    }

    init {
        prefs = PreferenceManager.getDefaultSharedPreferences(context)
    }

}