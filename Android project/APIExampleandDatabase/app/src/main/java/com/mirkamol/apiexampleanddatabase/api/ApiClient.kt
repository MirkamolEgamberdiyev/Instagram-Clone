package com.mirkamol.apiexampleanddatabase.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getRetrofit(): Retrofit{
        val build =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return build
    }

    fun <T> createService(service:Class<T>):T{
        return getRetrofit().create(service)
    }


}