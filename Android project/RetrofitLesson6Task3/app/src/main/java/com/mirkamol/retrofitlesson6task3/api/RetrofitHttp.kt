package com.mirkamol.retrofitlesson6task3.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHttp {
    private val IS_TESTER = true
    val SERVER_DEVELOPMENT ="https://jsonplaceholder.typicode.com/"
    val SERVER_PRODUCTION = "https://jsonplaceholder.typicode.com/"

    var retrofit: Retrofit = Retrofit.Builder().baseUrl(server()).addConverterFactory(GsonConverterFactory.create()).build()
    private fun server():String{
        return if (IS_TESTER){
            SERVER_DEVELOPMENT
        }else{
            SERVER_PRODUCTION
        }
    }

    val employeeService:EmployeeService= retrofit.create(EmployeeService::class.java)

}