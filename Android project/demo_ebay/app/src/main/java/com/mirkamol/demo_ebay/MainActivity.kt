package com.mirkamol.demo_ebay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.demo_ebay.adapter.FavoriteAdapter
import com.mirkamol.demo_ebay.adapter.HeadAdapter
import com.mirkamol.demo_ebay.adapter.Product1Adapter
import com.mirkamol.demo_ebay.adapter.Product2Adapter
import com.mirkamol.demo_ebay.model.Favorite
import com.mirkamol.demo_ebay.model.Head
import com.mirkamol.demo_ebay.model.Product1
import com.mirkamol.demo_ebay.model.Product2

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var twoRecyclerView: RecyclerView
    lateinit var threeRecyclerView: RecyclerView
    lateinit var fourRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        twoRecyclerView = findViewById(R.id.TworecyclerView)
        threeRecyclerView = findViewById(R.id.threeRecyclerView)
        fourRecyclerView = findViewById(R.id.fourRecyclerView)

        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = manager
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        twoRecyclerView.layoutManager = layoutManager

        val product1Manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        threeRecyclerView.layoutManager = product1Manager

        val product2Manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        fourRecyclerView.layoutManager = product2Manager

        refreshAdapter(getFavorites())
        refreshAdapter2(getAllHead())
        refreshProduct1Adapter(getProduct1())
        refreshProduct2Adapter(getProduct2())
    }

    private fun refreshProduct2Adapter(items:ArrayList<Product2>) {
        val adapter = Product2Adapter(items)
        fourRecyclerView.adapter = adapter
    }

    private fun refreshProduct1Adapter(items:ArrayList<Product1>) {
        val adapter = Product1Adapter(items)
        threeRecyclerView.adapter = adapter
    }

    private fun refreshAdapter2(items: ArrayList<Head>) {
        val adapter = HeadAdapter(items)
        twoRecyclerView.adapter = adapter
    }

    private fun refreshAdapter(items: ArrayList<Favorite>) {
        val adapter = FavoriteAdapter(this, items)
        recyclerView.adapter = adapter
    }


    fun getFavorites(): ArrayList<Favorite> {
        val items = ArrayList<Favorite>()

        for (i in 0..50) {
            items.add(Favorite("Apple watch", R.drawable.watch_image))
        }
        return items
    }

    fun getAllHead(): ArrayList<Head> {
        val items = ArrayList<Head>()

        for (i in 0..50) {
            items.add(
                Head(
                    R.drawable.img_1,
                    "Bose QuietComfort Earbuds",
                    "\$199.00",
                    "\$279.00 . 29% OFF"
                )
            )
        }

        return items
    }

    fun getProduct1():ArrayList<Product1>{
        val items = ArrayList<Product1>()

        for (i in 0..50){
            items.add(Product1(R.drawable.blankets_image, "Blankets"))
        }

        return items
    }
    fun getProduct2():ArrayList<Product2>{
     val items2 = ArrayList<Product2>()

        for (i in 0..50){
            items2.add(Product2(R.drawable.blankets_image, "Blankets"))
        }

        return items2
    }
}