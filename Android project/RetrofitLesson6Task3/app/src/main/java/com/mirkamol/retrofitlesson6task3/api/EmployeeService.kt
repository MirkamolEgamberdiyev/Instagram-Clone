package com.mirkamol.retrofitlesson6task3.api

import com.mirkamol.retrofitlesson6task3.model.Employ
import com.mirkamol.retrofitlesson6task3.model.ResponeListErrors
import com.mirkamol.retrofitlesson6task3.model.ResponseObjectErrors
import com.mirkamol.retrofitlesson6task3.model.User
import retrofit2.Call
import retrofit2.http.*

interface EmployeeService {


    @GET("posts")
    fun getAllPosts(): Call<ResponeListErrors<Employ>>

    @GET("employee/{id")
    fun getEmployee(@Path("id") id: Int): Call<ResponseObjectErrors<Employ>>

    @POST("create")
    fun createEmployee(@Body user: User): Call<Employ>

    @PUT("update/{id}")
    fun updateEmployee(@Path("id") id: Int, @Body user: User): Call<Employ>

    @DELETE("delete/{id}" )
    fun deleteEmployee(@Path("id") id: Int):Call<Employ>


}