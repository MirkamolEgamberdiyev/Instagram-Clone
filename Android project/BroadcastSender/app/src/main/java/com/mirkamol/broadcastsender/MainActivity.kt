package com.mirkamol.broadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)


    }

    fun sendBroadcast(v: View) {
        val intent = Intent("com.codinginflow.EXAMPLE_ACTION")
        intent.putExtra("com.codinginflow.EXTRA_TEXT", "Broadcast receiver")
        sendBroadcast(intent)
    }

    private val broadcastReciever = object :BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            var receiverText = intent.getStringExtra("com.codinginflow.EXTRA_TEXT")

            textView.text = receiverText
        }

    }

    override fun onStart() {
        super.onStart()
        IntentFilter("com.codinginflow.EXAMPLE_ACTION").also {
            registerReceiver(broadcastReciever, it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReciever)
    }
}
