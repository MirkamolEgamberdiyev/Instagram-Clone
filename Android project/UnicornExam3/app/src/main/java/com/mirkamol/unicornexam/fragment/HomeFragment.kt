package com.wonmirzo.fragment

import HomeCategoryAdapter
import HomeRestaruantAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.unicornexam.R
import com.wonmirzo.model.HomeCategoryItem
import com.wonmirzo.model.HomeRestaruantsItem

class HomeFragment : Fragment() {
    private lateinit var rvCat: RecyclerView
    private lateinit var rvRes: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        rvCat = view.findViewById(R.id.recyclerViewCat)
        rvRes = view.findViewById(R.id.recyclerViewRes)
        rvCat.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvRes.layoutManager = GridLayoutManager(requireContext(), 2)

        refreshAdapter(getAllItems())
        refreshResAdapter(getAllItemsRes())

        return view
    }

    private fun refreshAdapter(items: ArrayList<HomeCategoryItem>) {
        rvCat.adapter = HomeCategoryAdapter(requireContext(), items)
    }

    private fun refreshResAdapter(items: ArrayList<HomeRestaruantsItem>) {
        rvRes.adapter = HomeRestaruantAdapter(requireContext(), items)
    }

    private fun getAllItems(): ArrayList<HomeCategoryItem> {
        val items: ArrayList<HomeCategoryItem> = ArrayList()

        items.add(
            HomeCategoryItem(
                "https://images.pexels.com/photos/262978/pexels-photo-262978.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Restaruants"
            )
        )
        items.add(
            HomeCategoryItem(
                "https://images.pexels.com/photos/4963312/pexels-photo-4963312.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Coffee Shops"
            )
        )
        items.add(
            HomeCategoryItem(
                "https://images.pexels.com/photos/4068314/pexels-photo-4068314.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Shopping"
            )
        )
        items.add(
            HomeCategoryItem(
                "https://images.pexels.com/photos/674735/pexels-photo-674735.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Bike renting"
            )
        )

        return items
    }

    private fun getAllItemsRes(): ArrayList<HomeRestaruantsItem> {
        val items: ArrayList<HomeRestaruantsItem> = ArrayList()

        items.add(
            HomeRestaruantsItem(
                "https://images.pexels.com/photos/842571/pexels-photo-842571.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Gamine",
                "1231 Filmore St",
                4.5f
            )
        )
        items.add(
            HomeRestaruantsItem(
                "https://images.pexels.com/photos/2097090/pexels-photo-2097090.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Doppio Zero",
                "440 Fulton St",
                3.0f
            )
        )
        items.add(
            HomeRestaruantsItem(
                "https://images.pexels.com/photos/2641886/pexels-photo-2641886.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Lupa Trattoria",
                "200 Market St",
                5.0f
            )
        )
        items.add(
            HomeRestaruantsItem(
                "https://images.pexels.com/photos/286283/pexels-photo-286283.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Blackwood",
                "1100 Union St",
                4.0f
            )
        )

        return items
    }

}