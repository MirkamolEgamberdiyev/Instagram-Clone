package com.mirkamol.demo_youtube.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.demo_youtube.R
import com.mirkamol.demo_youtube.adapter.FeedAdapter
import com.mirkamol.demo_youtube.adapter.FilterAdapter
import com.mirkamol.demo_youtube.adapter.ShortAdapter
import com.mirkamol.demo_youtube.model.Feed
import com.mirkamol.demo_youtube.model.Filter
import com.mirkamol.demo_youtube.model.Short

class MainActivity : AppCompatActivity() {
    lateinit var recyclerFeed: RecyclerView
    lateinit var recyclerFilter: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {

        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerFilter = findViewById(R.id.recyclerFilter)
        recyclerFilter.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        refreshStoryAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeedss())
    }

    private fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerFeed.adapter = adapter
    }

    private fun refreshStoryAdapter(chats: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, chats)
        recyclerFilter.adapter = adapter
    }


    fun getAllshorts(): ArrayList<Short> {
        val shorts = ArrayList<Short>()
        for (i in 0..20) {
            shorts.add(
                com.mirkamol.demo_youtube.model.Short(
                    "https://youtu.be/ZPMcguaJg88", "MURAD NAZAROV JAMES BOND OBRAZIDA!", "\n" +
                            "4,1K views"
                )
            )
        }
        return shorts
    }

    fun getAllFilters(): ArrayList<Filter> {
        val filters = ArrayList<Filter>()
        filters.add(Filter("Computer programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))
        filters.add(Filter("Computer programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))
        return filters
    }

    fun getAllFeedss(): ArrayList<Feed> {

        return ArrayList<Feed>().apply {


                this.add(
                    Feed(
                        "https://yt3.ggpht.com/LLoRVw7onB5Bw-rSb5OXerG2Moj4S8Q56_bqs3fDu2dYZxr2EyRymHN6ybyUp9uzb4GlfMlu8A=s88-c-k-c0x00ffffff-no-rj",
                        "2aFBf7Qt6L0"
                    )
                )
                this.add(
                    Feed(
                        "https://yt3.ggpht.com/E81KY7SAPat3qrUuc1N7cztfr8QABJ0f3CUlOF_gQkH7cKP1K8lxaFyp8w3732goS4-pj5KhJpk=s88-c-k-c0x00ffffff-no-rj",
                        "MQIAKvjPwus"
                    )
                )
                this.add(
                    Feed(
                        "https://yt3.ggpht.com/pl-pa9hLg5NS2sXUlKsvpDwoinfjlKzYb8cM0zqGVxUUBDeRbGegGZbC8QRcPj62yiFzYN70Lg=s88-c-k-c0x00ffffff-no-rj",
                        "I7P3zMCPVLQ"
                    )
                )
                this.add(
                    Feed(
                        "https://yt3.ggpht.com/ytc/AKedOLQ01YVhDOp8uanTDAcSLvEmHoRNzj9ONYu488UiRg=s88-c-k-c0x00ffffff-no-rj",
                        "yi0OYUMqvAw"
                    )
                )


            this.add(
                Feed(
                    "https://yt3.ggpht.com/LLoRVw7onB5Bw-rSb5OXerG2Moj4S8Q56_bqs3fDu2dYZxr2EyRymHN6ybyUp9uzb4GlfMlu8A=s88-c-k-c0x00ffffff-no-rj",
                    "2aFBf7Qt6L0"
                )
            )
            this.add(
                Feed(
                    "https://yt3.ggpht.com/E81KY7SAPat3qrUuc1N7cztfr8QABJ0f3CUlOF_gQkH7cKP1K8lxaFyp8w3732goS4-pj5KhJpk=s88-c-k-c0x00ffffff-no-rj",
                    "MQIAKvjPwus"
                )
            )
            this.add(
                Feed(
                    "https://yt3.ggpht.com/pl-pa9hLg5NS2sXUlKsvpDwoinfjlKzYb8cM0zqGVxUUBDeRbGegGZbC8QRcPj62yiFzYN70Lg=s88-c-k-c0x00ffffff-no-rj",
                    "I7P3zMCPVLQ"
                )
            )
            this.add(
                Feed(
                    "https://yt3.ggpht.com/ytc/AKedOLQ01YVhDOp8uanTDAcSLvEmHoRNzj9ONYu488UiRg=s88-c-k-c0x00ffffff-no-rj",
                    "yi0OYUMqvAw"
                )
            )

        }
    }


}


