package com.mirkamol.lesson6volleynetworking.network

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.mirkamol.lesson6volleynetworking.activities.MyApplication
import com.mirkamol.lesson6volleynetworking.model.Data
import com.mirkamol.lesson6volleynetworking.network.volley.VolleyHandler
import com.mirkamol.lesson6volleynetworking.utils.Logger
import org.json.JSONObject


class VolleyHttp {

    companion object{
        val TAG = MyApplication::class.java.simpleName
        val IS_TESTER = true
        val SERVER_DEVELOPMENT ="http://dummy.restapiexample.com/api/v1/"
        val SERVER_PRODUCTION = "http://dummy.restapiexample.com/api/v1/"

        fun server(url:String):String{
            return if (IS_TESTER){
                SERVER_DEVELOPMENT + url
            }else{
                SERVER_PRODUCTION + url
            }
        }

        fun headers(): HashMap<String, String> {
            val headers = HashMap<String, String>()
            headers["Content-type"] = "application/json; charset=UTF-8"
            return headers
        }

        fun get(api: String, params: HashMap<String, String>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.GET, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.e(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getParams(): MutableMap<String, String> {
                    return params
                }
            }
            MyApplication.instance!!.addToRequestQueue(stringRequest)
        }
        // get single post
        fun getSinglePost(api: String, params: HashMap<String, String>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.GET, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.e(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getParams(): MutableMap<String, String> {
                    return params
                }
            }
            MyApplication.instance!!.addToRequestQueue(stringRequest)
        }

        fun post(api: String, body: HashMap<String, Any>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.POST, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getHeaders(): MutableMap<String, String> {
                    return headers()
                }

                override fun getBody(): ByteArray {
                    return JSONObject(body as Map<*, *>).toString().toByteArray()
                }
            }
            MyApplication.instance!!.addToRequestQueue(stringRequest)
        }

        fun put(api: String, body: HashMap<String, Any>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.PUT, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getHeaders(): MutableMap<String, String> {
                    return headers()
                }

                override fun getBody(): ByteArray {
                    return JSONObject(body as Map<*, *>).toString().toByteArray()
                }
            }
            MyApplication.instance!!.addToRequestQueue(stringRequest)
        }

        fun delete(url: String, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.DELETE, server(url),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
            }
            MyApplication.instance!!.addToRequestQueue(stringRequest)
        }

        /**
         *  Request Api`s
         */
        var API_LIST_POST = "employees"
        var API_SINGLE_POST = "employee/" //id
        var API_CREATE_POST = "create"
        var API_UPDATE_POST = "update/" //id
        var API_DELETE_POST = "delete/" //id

        /**
         *  Request Param`s
         */



        fun paramsEmpty(): HashMap<String, String> {
            return HashMap<String, String>()
        }

        fun paramsCreate(data: Data): HashMap<String, Any> {
            val params = HashMap<String, Any>()
            params["employee_name"] = data.employee_name
            params["employee_salary"] = data.employee_salary
            params["employee_age"] = data.employee_age
            params["profile_image"] = data.profile_image
            return params
        }

        fun paramsUpdate(data: Data): HashMap<String, Any> {
            val params = HashMap<String, Any>()
            params["employee_name"] = data.employee_name
            params["employee_salary"] = data.employee_salary
            params["employee_age"] = data.employee_age
            params["profile_image"] = data.profile_image
            return params
        }

        /**
         *  Response Parse`s
         */
    }
}