package com.mirkamol.multipartb13.api

import com.mirkamol.multipartb13.model.ImageResponce
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
@JvmSuppressWildcards
interface ApiService {

    @POST
    fun uploadPhoto(@Body body: RequestBody):Call<ImageResponce>

}