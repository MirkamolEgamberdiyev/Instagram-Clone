package com.mirkamol.uzblogsretrofit.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mirkamol.uzblogsretrofit.R
import com.mirkamol.uzblogsretrofit.adapter.PostAdapter
import com.mirkamol.uzblogsretrofit.adapter.UserAdapter
import com.mirkamol.uzblogsretrofit.adapter.UserAdapterListener
import com.mirkamol.uzblogsretrofit.api.ApiService
import com.mirkamol.uzblogsretrofit.api.BaseResponce
import com.mirkamol.uzblogsretrofit.model.PostModel
import com.mirkamol.uzblogsretrofit.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    lateinit var swipe: SwipeRefreshLayout
    lateinit var recylerUsers: RecyclerView
    lateinit var recyclerPosts: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipe = findViewById(R.id.swipe)
        recylerUsers = findViewById(R.id.recylerUsers)
        recyclerPosts = findViewById(R.id.recyclerPosts)


        swipe.setOnRefreshListener(this)

        swipe.isRefreshing = true
        loadUsers()
        loadPosts()

    }

    fun loadUsers() {
        ApiService.apiClient().getUsers().enqueue(object : Callback<BaseResponce<List<UserModel>>> {
            override fun onResponse(
                call: Call<BaseResponce<List<UserModel>>>,
                response: Response<BaseResponce<List<UserModel>>>
            ) {

                swipe.isRefreshing = false
                recylerUsers.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                recylerUsers.adapter = UserAdapter(response.body()?.data ?: emptyList(), object :UserAdapterListener{
                    override fun onClick(item: UserModel) {
                        val intent  = Intent(this@MainActivity, PostActivity::class.java)
                        intent.putExtra("extra_data", item)
                        startActivity(intent)
                    }
                })

            }

            override fun onFailure(call: Call<BaseResponce<List<UserModel>>>, t: Throwable) {
                swipe.isRefreshing = false
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
            }

        })
    }


    fun loadPosts() {
        ApiService.apiClient().getPosts().enqueue(object : Callback<BaseResponce<List<PostModel>>> {
            override fun onResponse(call: Call<BaseResponce<List<PostModel>>>, response: Response<BaseResponce<List<PostModel>>>) {

                recyclerPosts.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerPosts.adapter = PostAdapter(response.body()?.data ?: emptyList())
            }

            override fun onFailure(call: Call<BaseResponce<List<PostModel>>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
            }

        })


    }

    override fun onRefresh() {
        loadUsers()
        loadPosts()
    }
}