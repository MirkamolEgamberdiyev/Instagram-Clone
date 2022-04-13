package com.mirkamol.broadcastresiverservice.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class NetworkBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {

        if (intent != null) {
            if (ConnectivityManager.EXTRA_NO_CONNECTIVITY == intent.action)
                Toast.makeText(context, "Connectivity charged", Toast.LENGTH_SHORT).show()
        }
    }


}