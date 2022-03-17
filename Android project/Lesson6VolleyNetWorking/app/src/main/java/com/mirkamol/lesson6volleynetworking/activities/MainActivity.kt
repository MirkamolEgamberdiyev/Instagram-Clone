package com.mirkamol.lesson6volleynetworking.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mirkamol.lesson6volleynetworking.R
import com.mirkamol.lesson6volleynetworking.model.Data
import com.mirkamol.lesson6volleynetworking.model.MyResponse
import com.mirkamol.lesson6volleynetworking.network.VolleyHttp
import com.mirkamol.lesson6volleynetworking.network.volley.VolleyHandler
import com.mirkamol.lesson6volleynetworking.utils.Logger

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // apiUserList()
        //  apiUserPut()
        //  apiUserDelete()
       // apiUserCreatePost()
      apiUserSinglePost()
    }

    private fun apiUserCreatePost() {
        val data = Data(1, "Mirkamol Egamberdiyev", 782364, 22, "")
        VolleyHttp.post(
            VolleyHttp.API_CREATE_POST,
            VolleyHttp.paramsCreate(data),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    Logger.d("response", response.toString())
                }

                override fun onError(error: String?) {
                    Logger.e("error", error.toString())
                }

            })
    }

    private fun apiUserList() {
        VolleyHttp.get(VolleyHttp.API_LIST_POST, VolleyHttp.paramsEmpty(), object : VolleyHandler {
            override fun onSuccess(response: String?) {
                Logger.d("response", response.toString())
            }

            override fun onError(error: String?) {
                Logger.e("error", error.toString())
            }

        })
    }

    private fun apiUserPut() {
        val data = Data(1, "Mirkamol Egamberdiyev", 782364, 22, "")
        VolleyHttp.put(
            VolleyHttp.API_UPDATE_POST + data.id,
            VolleyHttp.paramsCreate(data),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    Logger.d("response", response.toString())
                }

                override fun onError(error: String?) {
                    Logger.e("error", error.toString())
                }

            })
    }

    private fun apiUserDelete() {
        val data = Data(5, "Mirkamol Egamberdiyev", 782364, 22, "")
        VolleyHttp.delete(VolleyHttp.API_DELETE_POST + data.id, object : VolleyHandler {
            override fun onSuccess(response: String?) {
                Logger.d("response", response.toString())
            }

            override fun onError(error: String?) {
                Logger.e("error", error.toString())
            }
        })
    }

    private fun apiUserSinglePost() {
        val data = Data(1, "Mirkamol Egamberdiyev", 782364, 22, "")
        VolleyHttp.getSinglePost(
            VolleyHttp.API_SINGLE_POST + data.id,
            VolleyHttp.paramsEmpty(),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    Logger.d("response", response.toString())
                }

                override fun onError(error: String?) {
                    Logger.e("error", error.toString())
                }
            })
    }

}