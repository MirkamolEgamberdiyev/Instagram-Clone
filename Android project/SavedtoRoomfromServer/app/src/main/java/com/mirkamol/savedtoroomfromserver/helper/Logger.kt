package com.mirkamol.savedtoroomfromserver.helper

import android.util.Log
import com.mirkamol.savedtoroomfromserver.networking.RetrofitHttp

object Logger {
    fun d(tag: String?, msg: String?) {
        if (RetrofitHttp.IS_TESTER) Log.d(tag, msg!!)
    }

    fun i(tag: String?, msg: String?) {
        if (RetrofitHttp.IS_TESTER) Log.i(tag, msg!!)
    }

    fun v(tag: String?, msg: String?) {
        if (RetrofitHttp.IS_TESTER) Log.v(tag, msg!!)
    }

    fun e(tag: String?, msg: String?) {
        if (RetrofitHttp.IS_TESTER) Log.e(tag, msg!!)
    }
}