package com.mirkamol.broadcastreceiverandalarm

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.Api
import com.mirkamol.broadcastreceiverandalarm.receiver.MyBroadcastReceiver
import com.mirkamol.broadcastreceiverandalarm.receiver.MyIntentService
import com.mirkamol.broadcastreceiverandalarm.receiver.SmsBroadcastReceiver

const val TYPEONE = 1
const val TYPETWO = 2

class MainActivity : AppCompatActivity() {
    private lateinit var myBroadcastReceiver: MyBroadcastReceiver
    private lateinit var smsBroadcastReceiver: SmsBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        myBroadcastReceiver = MyBroadcastReceiver()
//
//        val intentFilter = IntentFilter(ConnectivityManager.EXTRA_NO_CONNECTIVITY)
//        registerReceiver(myBroadcastReceiver, intentFilter)
       // registerSmsReceiver()
      //  startSmsUserConsent()
        startIntentService()
    }

    private fun startIntentService() {

        val intent = Intent(this, MyIntentService::class.java)
        intent.putExtra("type", TYPEONE)
        startService(intent)

        val intent2 = Intent(this, MyIntentService::class.java)
        intent2.putExtra("type", TYPETWO)
        startService(intent2)
    }

    private fun registerSmsReceiver() {
        smsBroadcastReceiver = SmsBroadcastReceiver()

        smsBroadcastReceiver.smsBroadcastReceiverListener =
            object : SmsBroadcastReceiver.SmsBroadcastReceiverListener {
                override fun onSuccess(intent: Intent?) {
                    val message = intent?.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE)
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }

                override fun onFailure() {

                }
            }


        val intentFilter = IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION)
        registerReceiver(smsBroadcastReceiver, intentFilter)

    }
    private fun startSmsUserConsent(){
        val client = SmsRetriever.getClient(this)
        client.startSmsUserConsent(null)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcastReceiver)
    }
}