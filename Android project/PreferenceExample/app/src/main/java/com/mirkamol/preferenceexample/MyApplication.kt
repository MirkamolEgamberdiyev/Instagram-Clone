package com.mirkamol.preferenceexample

import android.app.Application
import com.mirkamol.preferenceexample.manager.LocaleManager

class MyApplication : Application() {
    companion object {
        val TAG = MyApplication::class.java.simpleName
        var instance: MyApplication? = null
        var localManager: LocaleManager? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        localManager = LocaleManager(this)
        localManager!!.setLocale(this)
    }
}