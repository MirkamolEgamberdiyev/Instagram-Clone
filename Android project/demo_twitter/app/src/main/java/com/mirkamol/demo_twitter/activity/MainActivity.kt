package com.mirkamol.demo_twitter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.demo_twitter.R
import com.mirkamol.demo_twitter.adapter.FeedAdapter
import com.mirkamol.demo_twitter.adapter.StoryAdapter
import com.mirkamol.demo_twitter.model.Post
import com.mirkamol.demo_twitter.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerStory: RecyclerView
    lateinit var recyclerFeed: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerStory = findViewById(R.id.recyclerStory)
        recyclerStory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.layoutManager = GridLayoutManager(this, 1)

        refreshStoryAdapter(getAllStories())
        refreshFeedAdapter(getAllFeeds())
    }

    private fun getAllFeeds(): ArrayList<Post> {
        val posts = ArrayList<Post>()
        posts.add(Post(R.drawable.user, "Mirkamol Egamberdiyev", R.drawable.img_1))
        posts.add(Post(R.drawable.im_user, "Abdulaziz Abdullayev", R.drawable.post_2))
        posts.add(Post(R.drawable.user, "Barkamol Abdusamadov", R.drawable.post_2))
        posts.add(Post(R.drawable.im_user, "Mirkamol Egamberdiyev", R.drawable.img_1))
        posts.add(Post(R.drawable.user, "Mirkamol Egamberdiyev", R.drawable.post_2))
        posts.add(Post(R.drawable.im_user, "Mirkamol Egamberdiyev", R.drawable.img_1))
        posts.add(Post(R.drawable.user, "Mirkamol Egamberdiyev", R.drawable.post_2))
        posts.add(Post(R.drawable.user, "Mirkamol Egamberdiyev", R.drawable.img_1))
        posts.add(Post(R.drawable.im_user, "Abdulaziz Abdullayev", R.drawable.post_2))
        posts.add(Post(R.drawable.user, "Barkamol Abdusamadov", R.drawable.post_2))
        posts.add(Post(R.drawable.im_user, "Mirkamol Egamberdiyev", R.drawable.img_1))
        posts.add(Post(R.drawable.user, "Mirkamol Egamberdiyev", R.drawable.post_2))
        posts.add(Post(R.drawable.im_user, "Mirkamol Egamberdiyev", R.drawable.img_1))
        posts.add(Post(R.drawable.user, "Mirkamol Egamberdiyev", R.drawable.post_2))

        return posts

    }

    private fun getAllStories(): ArrayList<Story> {
        val stories = ArrayList<Story>()

        stories.add(Story(R.drawable.user, "Mirkamol"))
        stories.add(Story(R.drawable.user, "Bekzod"))
        stories.add(Story(R.drawable.im_user, "Jonibek"))
        stories.add(Story(R.drawable.im_user, "Barkamol"))
        stories.add(Story(R.drawable.user, "Mirkamol"))
        stories.add(Story(R.drawable.im_user, "Abdulaziz"))
        stories.add(Story(R.drawable.user, "Mirkamol"))
        stories.add(Story(R.drawable.user, "Bekzod"))
        stories.add(Story(R.drawable.im_user, "Jonibek"))
        stories.add(Story(R.drawable.im_user, "Barkamol"))
        stories.add(Story(R.drawable.user, "Mirkamol"))
        stories.add(Story(R.drawable.im_user, "Abdulaziz"))
        return stories
    }

    private fun refreshFeedAdapter(posts: ArrayList<Post>) {
        val adapter = FeedAdapter(this, posts)
        recyclerFeed.adapter = adapter
    }

    private fun refreshStoryAdapter(chats: ArrayList<Story>) {
        val adapter = StoryAdapter(this, chats)
        recyclerStory.adapter = adapter

    }
}