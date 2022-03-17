package com.mirkamol.androidnetworkniginjava.network.utils;

import android.util.Log;

import com.mirkamol.androidnetworkniginjava.network.volley.VolleyHttp;

public class Logger {

   public static void d(String tag, String msg) {
        if (VolleyHttp.IS_TESTER)
            Log.d(tag,  msg);
    }

   public static void i(String tag, String msg) {
        if (VolleyHttp.IS_TESTER)
            Log.d(tag,  msg);
    }

   public static void v(String tag, String msg) {
        if (VolleyHttp.IS_TESTER)
            Log.d(tag,  msg);
    }

  public   static void e(String tag, String msg) {
        if (VolleyHttp.IS_TESTER)
            Log.d(tag,  msg);
    }


}
