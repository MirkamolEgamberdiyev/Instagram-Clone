package com.mirkamol.broadcastresiverservice.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class ExampleBroadcastreceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        if ("com.codinginflow.EXAMPLE_ACTION".equals(intent.action)) {
          var receiverText = intent.getStringExtra("com.codinginflow.EXTRA_TEXT")

            Toast.makeText(context, receiverText, Toast.LENGTH_SHORT).show()
        }

    }
}