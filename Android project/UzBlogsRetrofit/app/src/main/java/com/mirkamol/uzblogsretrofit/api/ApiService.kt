package com.mirkamol.uzblogsretrofit.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    var retrofit:Retrofit? = null

    fun apiClient():Api{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://dummyapi.io/data/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!.create(Api::class.java)
    }
}