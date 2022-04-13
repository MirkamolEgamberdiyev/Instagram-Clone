package com.mirkamol.instagramclonejava.utils;

import static android.content.Context.WINDOW_SERVICE;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Toast;

import com.mirkamol.instagramclonejava.model.ScreenSize;

public class Utils {

    void fireToast(Context context,String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

  public   ScreenSize screenSize(Application context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)context.getSystemService(WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;
        return new ScreenSize(deviceWidth, deviceHeight);
    }
}
