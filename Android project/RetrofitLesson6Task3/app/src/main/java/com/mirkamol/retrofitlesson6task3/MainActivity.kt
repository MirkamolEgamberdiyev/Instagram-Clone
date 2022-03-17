package com.mirkamol.retrofitlesson6task3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mirkamol.retrofitlesson6task3.api.RetrofitHttp
import com.mirkamol.retrofitlesson6task3.model.Employ
import com.mirkamol.retrofitlesson6task3.model.ResponeListErrors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiCreatePost()

    }

    private fun apiCreatePost() {
        RetrofitHttp.employeeService.getAllPosts().enqueue(object : Callback<ResponeListErrors<Employ>> {
                override fun onResponse(call: Call<ResponeListErrors<Employ>>, response: Response<ResponeListErrors<Employ>>) {
                    Log.d(TAG, response.body().toString())
                }

                override fun onFailure(call: Call<ResponeListErrors<Employ>>, t: Throwable) {
                    Log.d(TAG, t.localizedMessage)
                }


            })
    }

}