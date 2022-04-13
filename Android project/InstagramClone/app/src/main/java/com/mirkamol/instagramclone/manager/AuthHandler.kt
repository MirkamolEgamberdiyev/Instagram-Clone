package com.mirkamol.instagramclone.manager

import java.lang.Exception

interface AuthHandler {
    fun onSuccess(uid:String)
    fun onError(exception: Exception?)
}