package com.mirkamol.lesson7task1retrofit.servies

import com.mirkamol.lesson7task1retrofit.model.Poster
import retrofit2.Call
import retrofit2.http.*

interface PostService {
    @Headers("Content-type: application/json")
    @GET("posts")
    fun getAllPosts(): Call<List<Poster>>

    @POST("posts/")
    fun createPost(@Body poster: Poster): Call<Poster>
    @PUT("posts/{id}")
    fun updatePost(@Path("id") id: Int, @Body post: Poster): Call<Poster>
    @DELETE("posts/{id}" )
    fun deletePost(@Path("id") id: Int):Call<Poster>





}