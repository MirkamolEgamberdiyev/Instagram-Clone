package com.mirkamol.instagramclone.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.instagramclone.R
import com.mirkamol.instagramclone.adapter.HomeAdapter
import com.mirkamol.instagramclone.model.Post
import java.lang.RuntimeException


class HomeFragment : BaseFragment() {
    private var listener:HomeListener? = null
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


        val iv_camera = view.findViewById<ImageView>(R.id.iv_camera)
        iv_camera.setOnClickListener {
            listener!!.scrollToUpload()
        }

        refreshAdapter(loadPosts())

    }

    private fun refreshAdapter(items:ArrayList<Post>){
        val adapter = HomeAdapter(this, items)
        recyclerView.adapter = adapter
    }
    private fun loadPosts():ArrayList<Post>{
        val items = ArrayList<Post>()
        items.add(Post("https://images.unsplash.com/photo-1649583243101-25f6a6453cfd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"))
        items.add(Post("https://images.unsplash.com/photo-1553603227-2358aabe821e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80"))
        items.add(Post("https://images.unsplash.com/photo-1561618030-ecca407d3ba4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80"))
        return items
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = if (context is HomeListener){
            context
        }else{
            throw RuntimeException("$context must implement HomeListener")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        listener = null
    }
    /**
     * This interface is created for communications  with UploadFragment
     */
    interface HomeListener {
        fun scrollToUpload()
    }


}