package com.mirkamol.broadcastreceiverandalarm.receiver

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log
import com.mirkamol.broadcastreceiverandalarm.TYPEONE
import com.mirkamol.broadcastreceiverandalarm.TYPETWO


class MyIntentService : IntentService("MyIntentService") {
    override fun onHandleIntent(intent: Intent?) {


        when(intent?.getIntExtra("type", 0 )){
            TYPEONE-> for (i in 0..9){
                Log.d("MyIntentService", "Task1 " + i)
                Thread.sleep(1000)
            }

            TYPETWO -> for (i in 0..9){
                Log.d("MyIntentService", "Task2 " + i)
                Thread.sleep(1000)
            }
        }

    }


}