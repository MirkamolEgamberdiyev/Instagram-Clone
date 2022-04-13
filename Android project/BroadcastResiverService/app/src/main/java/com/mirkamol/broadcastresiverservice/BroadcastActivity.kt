package com.mirkamol.broadcastresiverservice

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mirkamol.broadcastresiverservice.receivers.NetworkBroadcastReceiver
import org.w3c.dom.Text

class BroadcastActivity : AppCompatActivity() {
    lateinit var receiver:NetworkBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        initViews()
    }

    private fun initViews() {
        receiver = NetworkBroadcastReceiver()

        val tv_boot = findViewById<TextView>(R.id.tv_boot)
        val b_send = findViewById<Button>(R.id.b_send)

        b_send.setOnClickListener {

        }
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(ConnectivityManager.EXTRA_NO_CONNECTIVITY)
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}