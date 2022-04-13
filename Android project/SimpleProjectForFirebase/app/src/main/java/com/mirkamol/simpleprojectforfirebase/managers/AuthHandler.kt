package com.mirkamol.simpleprojectforfirebase.managers

import java.lang.Exception

interface AuthHandler {
    fun onSuccess()
    fun onError(exception: Exception?)
}