package com.mirkamol.uzblogsretrofit.api

import com.mirkamol.uzblogsretrofit.model.PostModel
import com.mirkamol.uzblogsretrofit.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Api {

    @Headers("app-id:622487b4b928b91a26f19d38")

    @GET("user?limit=10")
    fun getUsers():Call<BaseResponce<List<UserModel>>>

    @Headers("app-id:622487b4b928b91a26f19d38")
    @GET("post?limit=10")
    fun getPosts():Call<BaseResponce<List<PostModel>>>

    @Headers("app-id:622487b4b928b91a26f19d38")
    @GET("user/{user_id}/post?limit=10")
    fun getPostByUser(@Path("user_id") id:String):Call<BaseResponce<List<PostModel>>>
}