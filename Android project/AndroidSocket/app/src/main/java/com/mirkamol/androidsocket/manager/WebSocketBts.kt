package com.mirkamol.androidsocket.manager

import android.util.Log
import com.google.gson.Gson
import com.mirkamol.androidsocket.model.Bitcoin
import com.mirkamol.androidsocket.model.Currency
import com.mirkamol.androidsocket.model.DataSend
import okhttp3.*
import okio.ByteString

class WebSocketBts : WebSocketListener() {
    private lateinit var mWebSocker: WebSocket
    private var gson = Gson()
    private lateinit var socketListener:SocketListener
     fun connectToSocket() {
        val client = OkHttpClient()
        val request: Request = Request.Builder().url("wss://ws.bitstamp.net").build()


        client.newWebSocket(request, object : WebSocketListener() {

            override fun onOpen(webSocket: WebSocket, response: Response) {
                mWebSocker = webSocket
                webSocket.send(gson.toJson(Currency("bts:subscribe", DataSend("live_trades_btcusd")))

                )
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                Log.d("@@@", "Receiving: $text")
                val bitCoin = gson.fromJson(text, Bitcoin::class.java)

                socketListener.onSuccess(bitCoin)


            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                Log.d("@@@", "Receiving bytes: $bytes ")
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                Log.d("@@@", "Closing: $code / $reason")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                Log.d("@@@", "Error : " + t.message)
                socketListener.onFailure(t.localizedMessage)
            }
        })


        client.dispatcher.executorService.shutdown()
    }

    fun socketListener(socketListener: SocketListener){
        this.socketListener = socketListener
    }


}

interface SocketListener{
    fun onSuccess(bitcoin: Bitcoin)
    fun onFailure(message:String)
}