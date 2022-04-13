package com.mirkamol.instagramclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.instagramclone.R
import com.mirkamol.instagramclone.adapter.FavoriteAdapter
import com.mirkamol.instagramclone.model.Post

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(activity, 1)
        refreshAdapter(loadPosts())
    }

    private fun refreshAdapter(items:ArrayList<Post>){
        val adapter = FavoriteAdapter(this, items)
        recyclerView.adapter = adapter
    }
    private fun loadPosts():ArrayList<Post>{
        val items = ArrayList<Post>()
        items.add(Post("https://images.unsplash.com/photo-1649583243101-25f6a6453cfd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"))
        items.add(Post("https://images.unsplash.com/photo-1553603227-2358aabe821e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80"))
        items.add(Post("https://images.unsplash.com/photo-1561618030-ecca407d3ba4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80"))
        return items
    }

}