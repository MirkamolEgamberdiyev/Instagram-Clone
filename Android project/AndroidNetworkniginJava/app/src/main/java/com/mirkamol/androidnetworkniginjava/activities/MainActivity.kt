package com.mirkamol.androidnetworkniginjava.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mirkamol.androidnetworkniginjava.R
import com.mirkamol.androidnetworkniginjava.model.Poster
import com.mirkamol.androidnetworkniginjava.network.volley.VolleyHandler
import com.mirkamol.androidnetworkniginjava.network.volley.VolleyHttp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        controlVolley()
    }

    private fun controlVolley() {
      //  getPostVolley()
        workDelete()
    }

    private fun getPostVolley() {
        val poster = Poster(1, 1, "PDP", "Academy")
        VolleyHttp.put(VolleyHttp.API_UPDATE_POST + poster.id, VolleyHttp.paramsCreate(poster), object :VolleyHandler{
            override fun onSuccess(responce: String?) {
                Log.d("@@@", responce!!)
            }

            override fun onError(error: String?) {
                Log.d("@@@", error.toString())
            }

        })
    }

    fun workDelete(){
        val poster = Poster(1, 1, "PDP", "Online")
        VolleyHttp.deletePost(VolleyHttp.API_DELETE_POST + poster.id, object :VolleyHandler{
            override fun onSuccess(response: String?) {
                Log.d("@@@", response!!)
            }

            override fun onError(error: String?) {
                Log.d("@@@", error!!)
            }

        })
    }



}