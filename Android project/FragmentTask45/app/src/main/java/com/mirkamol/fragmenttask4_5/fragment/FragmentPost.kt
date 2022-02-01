package com.example.fragmenttask5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttask5.R
import com.example.fragmenttask5.adapter.PostAdapter
import com.example.fragmenttask5.model.Post


class FragmentPost : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private var postList = ArrayList<Post>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_post, container, false);
        initViews(view)
        return view;
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recycler_post)
        recyclerView.layoutManager = GridLayoutManager(requireContext(),1)
        postAdapter = PostAdapter(postList())
        recyclerView.adapter = postAdapter
    }

    private fun postList(): ArrayList<Post> {
        for (i in 0..30) {
            postList.add(Post(R.drawable.img_sample_post,"Google","Our mission is to organize the world’s information and make it universally accessible and useful."))
        }
        return postList
    }

}