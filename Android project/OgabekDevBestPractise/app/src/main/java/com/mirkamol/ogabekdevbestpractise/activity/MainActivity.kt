package com.mirkamol.ogabekdevbestpractise.activity

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.ogabekdevbestpractise.R
import com.mirkamol.ogabekdevbestpractise.adapter.UserAdapter
import com.mirkamol.ogabekdevbestpractise.adapter.savedUserAdapter
import com.mirkamol.ogabekdevbestpractise.database.UserDB
import com.mirkamol.ogabekdevbestpractise.database.UserRepository
import com.mirkamol.ogabekdevbestpractise.helper.Logger
import com.mirkamol.ogabekdevbestpractise.model.User
import com.mirkamol.ogabekdevbestpractise.networking.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val TAG: String = MainActivity::class.java.simpleName
    private lateinit var userList: ArrayList<User>
    private lateinit var savedList: ArrayList<UserDB>
    private lateinit var adapter: UserAdapter
    lateinit var savedAdapter: savedUserAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        initViews()
    }

    private fun initViews() {
        userList = ArrayList()
        savedList = ArrayList()


        if (isInternetAvailable()) {
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recyclerView.layoutManager = layoutManager
            refreshAdapter(userList)

            getUsers()
        } else {
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recyclerView.layoutManager = layoutManager

            savedRefreshAdapter(savedList)
            getUsersFromDatabse()

        }
    }


    private fun refreshAdapter(list: ArrayList<User>) {
        adapter = UserAdapter(list)
        recyclerView.adapter = adapter
    }

    private fun savedRefreshAdapter(list: ArrayList<UserDB>) {
        savedAdapter = savedUserAdapter(list)
        recyclerView.adapter = savedAdapter
    }

    private fun getUsersFromDatabse() {
        val repository = UserRepository(application)
        savedList.addAll(repository.getUsers())
        savedAdapter.notifyDataSetChanged()
        Logger.d(TAG, repository.getUsers().toString())
    }

    private fun getUsers() {
        RetrofitHttp.userService.getAllUsers().enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                if (response.body() != null) {
                    Logger.d(TAG, "onResponce: ${response.body().toString()}")
                    userList.clear()
                    userList.addAll(response.body()!!)
                    adapter.notifyDataSetChanged()

                    saveToDatabase(response.body()!!)
                } else {
                    Logger.e(TAG, "onResponce: null")
                }

            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                Logger.e(TAG, "onFailure: ${t.localizedMessage}")
            }

        })
    }

    private fun saveToDatabase(respond: ArrayList<User>) {
        val repository = UserRepository(application)
        repository.deleteUsers()
        for (i in respond) {
            val userDB = UserDB(i.id!!, i.username, i.full_name, i.is_online)

            repository.saveUser(userDB)

        }
    }

    private fun isInternetAvailable(): Boolean {
        val manager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val infoMobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        val infoWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        return infoMobile!!.isConnected || infoWifi!!.isConnected
    }
}