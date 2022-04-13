package com.mirkamol.broadcastreceiverandalarm.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class MyBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {

        if (isConnectingToInernet(context!!)){
            Toast.makeText(context, "Internet Connetcted", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Internet Disconnected", Toast.LENGTH_SHORT).show()
        }

    }

    private fun isConnectingToInernet(context: Context):Boolean{
        val cm = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}