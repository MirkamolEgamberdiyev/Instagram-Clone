package com.mirkamol.retrofitexample.api

import com.mirkamol.retrofitexample.model.ResponceItem
import com.mirkamol.retrofitexample.model.Sponsor
import com.mirkamol.retrofitexample.model.Topic
import retrofit2.Call
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiService {


    @GET("photos/{id}")
    fun getPhoto(@Path("id") id:String):Call<ResponceItem>

    @GET("photos")
    fun getPhotos(@Query("page") page:Int, @Query("per_page") per_page: Int): Call<List<Sponsor>>

    @GET("collections")
    fun getCollections(@Query("page") page:Int, @Query("per_page") per_page: Int): Call<List<Sponsor>>

    @GET("topics")
    fun getTopics(@Query("page") page:Int, @Query("per_page") per_page: Int): Call<List<Topic>>

    @GET("search/photoes?")
    fun getSearchPhotoes(@Query("page") page:Int, @Query("per_page", ) per_page: Int, @Query("query") queryText:String ): Call<List<Topic>>

    @GET("photos/{id}")
    fun getSelectedPhoto(@Path("id") id: String): Call<Sponsor>



//    @GET("collections/{id}/related")
//    fun getRelatedCollections(@Path("id") id :String):Call<ResponceItem>





}