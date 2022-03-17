package com.mirkamol.retrofitexample.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mirkamol.retrofitexample.R
import com.mirkamol.retrofitexample.adapter.SearchAdapter
import com.mirkamol.retrofitexample.api.ApiService
import com.mirkamol.retrofitexample.api.RetrofitHttp
import com.mirkamol.retrofitexample.model.Topic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment(R.layout.fragment_search), SearchAdapter.OnItemClickListener {
    lateinit var adapter: SearchAdapter
    private lateinit var list: ArrayList<Topic>
    lateinit var recyclerView: RecyclerView
    lateinit var rvPopular: RecyclerView
    private lateinit var apiService: ApiService
    lateinit var editText: EditText
    var page = 0
    var per_page = 8
    private val TAG = "search Fragment"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv_ideas)
        rvPopular = view.findViewById(R.id.rv_popular)
        initViews()
        editText = view.findViewById(R.id.et_search)

        editText.setOnClickListener {
            Log.d(TAG, "onItemClicked: awdawdawd")
            parentFragmentManager.beginTransaction().replace(R.id.nav_host_main, SearchingFragment())
                .addToBackStack(null)
                .commit()
        }

    }

    fun initViews() {
        list = ArrayList()
        apiService = RetrofitHttp.createServiceWithAuth(ApiService::class.java)


        adapter = SearchAdapter(requireContext(), list, this)
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager
        recyclerView.adapter = adapter
        rvPopular.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvPopular.adapter = adapter
        apiTopicsList()






    }

    private fun apiTopicsList() {
        RetrofitHttp.apiService.getTopics(page, per_page)
            .enqueue(object : Callback<List<Topic>> {
                override fun onResponse(
                    call: Call<List<Topic>>,
                    response: Response<List<Topic>>
                ) {
                    list.addAll(response.body() as ArrayList<Topic>)
                    adapter.notifyDataSetChanged()
                    Log.d("TAG", response.body().toString())
                }

                override fun onFailure(call: Call<List<Topic>>, t: Throwable) {
                    Log.d("error", t.localizedMessage)
                }
            })
    }

    override fun onItemClicked() {
        Log.d(TAG, "onItemClicked: awdawdawd")
        parentFragmentManager.beginTransaction().replace(R.id.nav_host_main, SearchPresentFragment())
            .addToBackStack(null)
            .commit()
    }


}
