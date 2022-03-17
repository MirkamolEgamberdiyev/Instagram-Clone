package com.mirkamol.lesson6volleynetworking.activities

import android.app.Application
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.mirkamol.lesson6volleynetworking.network.VolleyHttp.Companion.TAG

class MyApplication:Application() {

    companion object{
        var instance:MyApplication? = null
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.d(TAG, "onCreate: ")
    }

    private val requestQueue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(applicationContext)
            }
            return field
        }

    fun <T> addToRequestQueue(request: Request<T>) {
        request.tag = TAG
        requestQueue?.add(request)
    }
}