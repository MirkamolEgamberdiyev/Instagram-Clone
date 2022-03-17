package com.mirkamol.apiexampleanddatabase.api

import com.mirkamol.apiexampleanddatabase.model.Data
import com.mirkamol.apiexampleanddatabase.model.Photo
import com.mirkamol.apiexampleanddatabase.model.Post
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("activity")
    fun getActivity(): Call<Data>
    @GET("activity")
    fun getKey(@Query("key") key:String):Call<Data>
    @GET("activity")
    fun getType(@Query("type") type:String):Call<Data>
    @GET("activity")
    fun getMaxAndMin(@Query("minprice") minprice:Int,
    @Query("maxprice") maxprice:Double):Call<Data>

    @GET("posts/{id}")
    fun  getPhotos(@Path("id") postId:Int):Call<Post>

    @POST("posts")
    fun createPost(@Body map:HashMap<String, Any>):Call<Post>




}