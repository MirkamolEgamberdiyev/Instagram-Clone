package com.mirkamol.broadcastreceiverandalarm.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.telecom.Call

class CallBroadcastReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent !=null){
            if (intent.action == Call.STATE_PULLING_CALL.toString()){
                val extac = intent.extras

            }
        }
    }
}