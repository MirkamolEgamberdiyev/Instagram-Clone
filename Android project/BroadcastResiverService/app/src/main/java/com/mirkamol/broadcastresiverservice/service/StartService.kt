package com.mirkamol.broadcastresiverservice.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast

class StartService:Service() {
    private var player:MediaPlayer? = null
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        Toast.makeText(this, "Started Service Created", Toast.LENGTH_SHORT).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        // This will play the ringtone continuously until we stop the service

        player!!.isLooping = true
        //It will start the player
        player!!.start()
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

        player!!.start()

        Toast.makeText(this, "Started Service Stopped", Toast.LENGTH_SHORT).show()
    }
}