package com.mirkamol.localization_lesson1

import android.app.Application
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                super.log(priority, "global_tag$tag", message, t)
            }

            override fun createStackElementTag(element: StackTraceElement): String? {
                return String.format("%s:%S", element.methodName,
                    element.lineNumber,
                    super.createStackElementTag(element))
            }
        })

        Timber.d("App Created!")
    }
}