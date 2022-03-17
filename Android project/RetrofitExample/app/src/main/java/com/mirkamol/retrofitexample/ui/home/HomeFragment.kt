package com.mirkamol.retrofitexample.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mirkamol.retrofitexample.listener.EndlessRecyclerViewScrollListener
import com.mirkamol.retrofitexample.R
import com.mirkamol.retrofitexample.adapter.PhotosAdapter
import com.mirkamol.retrofitexample.api.RetrofitHttp
import com.mirkamol.retrofitexample.api.ApiService
import com.mirkamol.retrofitexample.listener.SpaceItemDecoration
import com.mirkamol.retrofitexample.model.Sponsor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var apiService: ApiService
    lateinit var adapter: PhotosAdapter
    lateinit var swipe: SwipeRefreshLayout
    lateinit var recyclerView: RecyclerView
    private lateinit var list: ArrayList<Sponsor>
    private lateinit var navController: NavController
    private val TAG = "HomeFragment"
    var page = 1
    var per_page = 20

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        navController = Navigation.findNavController(view)

        swipe = view.findViewById(R.id.swipe)

        swipe.setOnRefreshListener(this)
        swipe.isRefreshing = true

       initViews()
    }

    override fun onRefresh() {
        initViews()
    }

    private fun initViews() {
        list = ArrayList()
        apiService = RetrofitHttp.createServiceWithAuth(ApiService::class.java)
        adapter = PhotosAdapter(list)
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager
        recyclerView.addItemDecoration(SpaceItemDecoration(20))
        recyclerView.adapter = adapter

        apiPhotosList()

        val scrollListener = object : EndlessRecyclerViewScrollListener(
            staggeredGridLayoutManager
        ) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                apiPhotosList()
            }
        }
        recyclerView.addOnScrollListener(scrollListener)
        controlItemClick()

    }

    private fun controlItemClick() {
        adapter.photoClick = {
            navController.navigate(
                R.id.action_homeFragment_to_imagePresenterFragment3,
                bundleOf("photoID" to it.id, "photoUrl" to it.urls.regular)
            )
        }
    }

    fun apiPhotosList() {
        swipe.isRefreshing = true
        RetrofitHttp.apiService.getPhotos(page++, per_page)
            .enqueue(object : Callback<List<Sponsor>> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<List<Sponsor>>,
                    response: Response<List<Sponsor>>
                ) {
                    Log.d("Responce", response.body().toString())
                    swipe.isRefreshing = false
                   list.addAll(response.body()!! as ArrayList<Sponsor>)
                    adapter.notifyDataSetChanged()

                    swipe.isRefreshing = false
                }
                override fun onFailure(call: Call<List<Sponsor>>, t: Throwable) {
                    Log.d("errorONFAIL", t.localizedMessage)
                }
            })
    }


}