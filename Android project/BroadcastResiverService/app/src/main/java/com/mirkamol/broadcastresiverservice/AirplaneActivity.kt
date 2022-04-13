package com.mirkamol.broadcastresiverservice

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mirkamol.broadcastresiverservice.receivers.ExampleBroadcastreceiver

class AirplaneActivity : AppCompatActivity() {
    lateinit var receiver:ExampleBroadcastreceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_airplane)

        receiver = ExampleBroadcastreceiver()
        IntentFilter("com.codinginflow.EXAMPLE_ACTION").also {
            registerReceiver(receiver, it)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

}