package com.mirkamol.broadcastreceiverandalarm.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

class SmsBroadcastReceiver:BroadcastReceiver() {
    var smsBroadcastReceiverListener:SmsBroadcastReceiverListener? = null
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null) {
            if (intent.action == SmsRetriever.SMS_RETRIEVED_ACTION){
                val extas = intent.extras
                val smsRetrieverStatus = extas!![SmsRetriever.EXTRA_STATUS] as Status

                when(smsRetrieverStatus.statusCode){
                    CommonStatusCodes.SUCCESS ->{
                        val messageIntent =extas.getParcelable<Intent>(SmsRetriever.EXTRA_CONSENT_INTENT)
                        smsBroadcastReceiverListener!!.onSuccess(messageIntent)
                    }

                    CommonStatusCodes.TIMEOUT -> smsBroadcastReceiverListener!!.onFailure()
                }
            }

        }
    }
    interface SmsBroadcastReceiverListener{
        fun onSuccess(intent: Intent?)
        fun onFailure()
    }
}