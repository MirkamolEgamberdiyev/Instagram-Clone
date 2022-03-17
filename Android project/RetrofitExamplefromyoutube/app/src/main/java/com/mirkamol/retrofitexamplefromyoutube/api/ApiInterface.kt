package com.mirkamol.retrofitexamplefromyoutube.api

import com.mirkamol.retrofitexamplefromyoutube.model.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface  {

    @GET("posts")
    fun getDada():Call<List<MyDataItem>>
}