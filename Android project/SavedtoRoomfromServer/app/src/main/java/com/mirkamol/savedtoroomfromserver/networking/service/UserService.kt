package com.mirkamol.savedtoroomfromserver.networking.service
import com.mirkamol.savedtoroomfromserver.model.UserItem
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("Poster")
    fun getAllUsers():Call<ArrayList<UserItem>>
}