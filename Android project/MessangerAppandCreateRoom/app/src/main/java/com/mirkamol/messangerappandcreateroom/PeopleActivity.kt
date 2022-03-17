package com.mirkamol.messangerappandcreateroom


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.messangerappandcreateroom.adapter.StoriesAdapter
import com.mirkamol.messangerappandcreateroom.model.StoriesModel

class PeopleActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)


        initViews()

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.rv_people)
        val manager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = manager

        refreshAdapter(addStories())

    }

    private fun refreshAdapter(items:ArrayList<StoriesModel>){
        val adapter = StoriesAdapter(items)
        recyclerView.adapter = adapter
    }


    private fun addStories():ArrayList<StoriesModel>{
        val items = ArrayList<StoriesModel>()


            items.add(StoriesModel(R.drawable.ic_profile, 1, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 2, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 3, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 4, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 5, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 6, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 7, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 8, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 9, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 10, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 11, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 12, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 13, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 14, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 15, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 16, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 17, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 18, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 19, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 20, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 21, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 22, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 23, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))
        items.add(StoriesModel(R.drawable.ic_profile, 24, R.drawable.ic_profile,"Mirkamol Egamberdiyev"))




        return items
    }


}