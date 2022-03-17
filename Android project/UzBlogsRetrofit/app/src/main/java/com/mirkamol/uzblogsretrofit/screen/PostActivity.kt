package com.mirkamol.uzblogsretrofit.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mirkamol.uzblogsretrofit.R
import com.mirkamol.uzblogsretrofit.adapter.PostAdapter
import com.mirkamol.uzblogsretrofit.api.ApiService
import com.mirkamol.uzblogsretrofit.api.BaseResponce
import com.mirkamol.uzblogsretrofit.model.PostModel
import com.mirkamol.uzblogsretrofit.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    lateinit var user: UserModel
    lateinit var tvTitle: TextView
    lateinit var swipe: SwipeRefreshLayout
    lateinit var recylerPosts: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        tvTitle = findViewById(R.id.tvTitle)
        swipe = findViewById(R.id.swipe)
        recylerPosts = findViewById(R.id.recylerPosts)


        user = intent.getSerializableExtra("extra_data") as UserModel

        tvTitle.text = user.firstName + " " + user.lastName

        swipe.setOnRefreshListener(this)
        loadPost()

    }

    override fun onRefresh() {
        loadPost()
    }

    private fun loadPost() {
        swipe.isRefreshing = true

        ApiService.apiClient().getPostByUser(user.id)
            .enqueue(object : Callback<BaseResponce<List<PostModel>>> {
                override fun onResponse(
                    call: Call<BaseResponce<List<PostModel>>>,
                    response: Response<BaseResponce<List<PostModel>>>
                ) {

                    swipe.isRefreshing = false
                    recylerPosts.layoutManager = LinearLayoutManager(this@PostActivity)
                    recylerPosts.adapter = PostAdapter(response.body()?.data ?: emptyList())
                }

                override fun onFailure(call: Call<BaseResponce<List<PostModel>>>, t: Throwable) {
                    swipe.isRefreshing = false
                    Toast.makeText(this@PostActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
                }

            })
    }


}