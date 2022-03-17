package com.mirkamol.lesson7task1retrofit.servies

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHttp {
    private val IS_TESTER = true
    val SERVER_DEVELOPMENT ="https://jsonplaceholder.typicode.com/"
    val SERVER_PRODUCTION = "https://jsonplaceholder.typicode.com/"

    var retrofit = Retrofit.Builder().baseUrl(server()).addConverterFactory(GsonConverterFactory.create()).build()
    private fun server():String{
        return if (IS_TESTER){
            SERVER_DEVELOPMENT
        }else{
            SERVER_PRODUCTION
        }
    }

    val postService:PostService = retrofit.create(PostService::class.java)
}