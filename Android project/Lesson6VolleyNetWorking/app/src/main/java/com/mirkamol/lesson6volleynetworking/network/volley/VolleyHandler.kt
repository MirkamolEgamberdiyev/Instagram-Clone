package com.mirkamol.lesson6volleynetworking.network.volley

interface VolleyHandler {
    fun onSuccess(response:String?)
    fun onError(error:String?)
}