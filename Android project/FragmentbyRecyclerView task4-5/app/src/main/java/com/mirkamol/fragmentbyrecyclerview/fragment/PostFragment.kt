package com.mirkamol.fragmentbyrecyclerview.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.fragmentbyrecyclerview.R
import com.mirkamol.fragmentbyrecyclerview.adapters.PostAdapter
import com.mirkamol.fragmentbyrecyclerview.listener.OnClickListenerShare
import com.mirkamol.fragmentbyrecyclerview.model.Post


class PostFragment : Fragment() {
    private lateinit var postAdapter: PostAdapter
    private lateinit var recyclerView: RecyclerView
    lateinit var posts: ArrayList<Post>

    private var onClickListenerShare = object : OnClickListenerShare {
        override fun sharePost(position: Int) {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "image/plain"
            val uri = Uri.parse(
                "android.resource://" + R::class.java.getPackage().name + "/" + posts[position].image
            )
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
            shareIntent.putExtra(Intent.EXTRA_TEXT, posts[position].description)
            startActivity(Intent.createChooser(shareIntent, "Share"))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.rv_post)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        posts = addPosts()

        refreshAdapter()
    }

    private fun refreshAdapter() {
        postAdapter = PostAdapter(posts, onClickListenerShare)
        recyclerView.adapter = postAdapter
    }

    private fun addPosts(): ArrayList<Post> {
        val posts = ArrayList<Post>()
        for (i in 0..10) {
            posts.add(Post(R.drawable.img, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_1, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_2, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_3, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_4, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_5, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_6, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_7, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_8, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_9, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_10, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_11, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_12, "This is beautiful landscapes"))
            posts.add(Post(R.drawable.img_13, "This is beautiful landscapes"))

        }
        return posts
    }

}