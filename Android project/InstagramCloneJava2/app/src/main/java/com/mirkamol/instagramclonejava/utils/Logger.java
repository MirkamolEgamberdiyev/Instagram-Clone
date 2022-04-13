package com.mirkamol.instagramclonejava.utils;

import android.util.Log;

public class Logger {
    Boolean IS_TESTER = true;
   public void d (String tag, String msg){
        if (IS_TESTER){
            Log.d(tag, msg);
        }
    }

    public void i(String tag, String msg){
        if (IS_TESTER){
            Log.d(tag, msg);
        }
    }

  public   void v (String tag, String msg){
        if (IS_TESTER){
            Log.d(tag, msg);
        }
    }

   public void e(String tag, String msg){
        if (IS_TESTER){
            Log.d(tag, msg);
        }
    }

}
