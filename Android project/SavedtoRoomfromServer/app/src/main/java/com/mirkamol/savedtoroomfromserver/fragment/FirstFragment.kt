package com.mirkamol.savedtoroomfromserver.fragment

import android.app.Application
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.savedtoroomfromserver.R
import com.mirkamol.savedtoroomfromserver.adapter.UserAdapter
import com.mirkamol.savedtoroomfromserver.database.UserRepasitory
import com.mirkamol.savedtoroomfromserver.helper.Logger
import com.mirkamol.savedtoroomfromserver.model.UserItem
import com.mirkamol.savedtoroomfromserver.networking.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var userList: ArrayList<UserItem>
    private lateinit var adapter: UserAdapter
    lateinit var recyclerView: RecyclerView
    private lateinit var savedList: ArrayList<UserItem>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)


        initviews()


    }

    private fun initviews() {
        userList = ArrayList()
        savedList = ArrayList()

        if (isInternetAvailable()) {
            val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            recyclerView.layoutManager = layoutManager
            refreshAdapter(userList)

            getUsers()
        } else {
            val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            recyclerView.layoutManager = layoutManager

            refreshAdapter(savedList)

            getUsersFromDatabse()

        }
    }

    private fun refreshAdapter(list: ArrayList<UserItem>) {
        adapter = UserAdapter(requireContext(), list)
        recyclerView.adapter = adapter
    }



    private fun getUsersFromDatabse() {
        val repository = UserRepasitory(requireActivity().application)
        savedList.addAll(repository.getUsers())
        adapter.notifyDataSetChanged()

    }

    private fun getUsers() {
        RetrofitHttp.userService.getAllUsers().enqueue(object : Callback<ArrayList<UserItem>> {
            override fun onResponse(
                call: Call<ArrayList<UserItem>>,
                response: Response<ArrayList<UserItem>>
            ) {
                Logger.d("responce", response.body().toString())
                userList.clear()
                userList.addAll(response.body()!!)
                adapter.notifyDataSetChanged()

                saveToDatabase(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<UserItem>>, t: Throwable) {
             Logger.e("MainActivity", t.localizedMessage)
            }

        })
    }



    private fun saveToDatabase(respond: ArrayList<UserItem>) {
        val repository = UserRepasitory(requireActivity().application)
        repository.deleteUsers()
        for (i in respond) {
            val user = UserItem(i.id!!, i.image, i.name, i.phone)

            repository.saveUser(user)

        }

    }

    private fun isInternetAvailable(): Boolean {
        val manager = getActivity()?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val infoMobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        val infoWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        return infoMobile!!.isConnected || infoWifi!!.isConnected
    }

}