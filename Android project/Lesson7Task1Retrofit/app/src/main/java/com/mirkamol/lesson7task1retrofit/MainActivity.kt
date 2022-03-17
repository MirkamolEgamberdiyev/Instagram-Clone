package com.mirkamol.lesson7task1retrofit

import PosterAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mirkamol.lesson7task1retrofit.model.Poster
import com.mirkamol.lesson7task1retrofit.servies.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    var TAG = "MainActivity"
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var swipe: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        swipe = findViewById(R.id.swipe)


        swipe.setOnRefreshListener(this)
        swipe.isRefreshing = true

        getAllPosts()
        deletePost(1)

    }

    fun getAllPosts() {
        RetrofitHttp.postService.getAllPosts()
            .enqueue(object : Callback<List<Poster>> {
                override fun onResponse(
                    call: Call<List<Poster>>,
                    response: Response<List<Poster>>
                ) {

                   // Log.d(TAG, "onResponsewdaadawdwawd ${response.body()!!.size}")
                    swipe.isRefreshing = false
                    progressBar.isVisible = false
                    recyclerView.layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    recyclerView.adapter =
                        PosterAdapter(this@MainActivity, response.body() ?: emptyList())

                }

                override fun onFailure(call: Call<List<Poster>>, t: Throwable) {
                    swipe.isRefreshing = false
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
                }

            })

    }

    fun createPosts(){
        val post = Poster("PDP", 9991, "Academy", 9981)
        RetrofitHttp.postService.createPost(post).enqueue(object:Callback<Poster>{
            override fun onResponse(call: Call<Poster>, response: Response<Poster>) {

                swipe.isRefreshing = false
                progressBar.isVisible = false
                getAllPosts()
               // Log.d(TAG, "onResponsewdadwawd")

            }

            override fun onFailure(call: Call<Poster>, t: Throwable) {
                swipe.isRefreshing = false
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
            }

        })
    }

    fun deletePost(poster: Int){
        RetrofitHttp.postService.deletePost(poster).enqueue(object :Callback<Poster>{
            override fun onResponse(call: Call<Poster>, response: Response<Poster>) {
                swipe.isRefreshing = false
                progressBar.isVisible = false
                getAllPosts()
                Log.d(TAG, "onResponsewdadwawd")
            }

            override fun onFailure(call: Call<Poster>, t: Throwable) {
                swipe.isRefreshing = false
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onRefresh() {
        getAllPosts()
        createPosts()
    }


     fun dialogPoster(poster: Int) {
         AlertDialog.Builder(this)
             .setTitle("Delete Poster")
             .setMessage("Are you sure you want to delete this poster?")
             .setPositiveButton(
                 android.R.string.yes
             ){
                     dialog, which -> deletePost(poster)
             }
             .setNegativeButton(android.R.string.no, null)
             .setIcon(android.R.drawable.ic_dialog_alert)
             .show()
     }

}