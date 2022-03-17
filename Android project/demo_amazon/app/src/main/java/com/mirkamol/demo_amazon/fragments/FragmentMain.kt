package com.mirkamol.demo_amazon.fragments

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mirkamol.demo_amazon.R
import com.mirkamol.demo_amazon.adapter.DepartmentAdapter
import com.mirkamol.demo_amazon.adapter.FavoriteAdapter
import com.mirkamol.demo_amazon.adapter.SneakerAdapter
import com.mirkamol.demo_amazon.databinding.FragmentMainBinding
import com.mirkamol.demo_amazon.model.Department
import com.mirkamol.demo_amazon.model.Essential
import com.mirkamol.demo_amazon.model.Sneakers

class FragmentMain : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    lateinit var recyclerView: RecyclerView
    lateinit var snkRecyclerView: RecyclerView
    lateinit var dpRecyclerView: RecyclerView
    lateinit var nav_view: BottomNavigationView

    //lateinit var ll_fashion: LinearLayout
    //lateinit var ll_popular: LinearLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }


    private fun initViews() {
        // ll_fashion = findViewById(R.id.ll_fashion)
       // ll_popular = requireView().findViewById(R.id.ll_popular)

        recyclerView = requireView().findViewById(R.id.rv_essential)
        snkRecyclerView = requireView().findViewById(R.id.snk_recyclerView)

        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = manager

        val sneakerManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        snkRecyclerView.layoutManager = sneakerManager


        dpRecyclerView = requireView().findViewById(R.id.dp_recyclerView)
        val dpManager = GridLayoutManager(requireContext(), 2)
        dpRecyclerView.layoutManager = dpManager


        //  setLinearHeight(ll_fashion)
       // setLinearHeight(ll_popular)

        refreshAdapter(getEssentials())
        refreshAdapterSneaker(getSneakers())
        refreshAdapterDepartment(getDepartments())
    }

    private fun setLinearHeight(layout: LinearLayout) {

        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        var widthPixels = displayMetrics.widthPixels


        val heightInDp: Int = widthPixels / resources.displayMetrics.density.toInt()
        val params: ViewGroup.LayoutParams = layout.layoutParams
        params.height = heightInDp
        layout.layoutParams = params
    }

    private fun refreshAdapter(items: ArrayList<Essential>) {
        val adapter = FavoriteAdapter(requireContext(), items)
        recyclerView.adapter = adapter


    }

    private fun refreshAdapterSneaker(items: ArrayList<Sneakers>) {
        val sneakerAdaptet = SneakerAdapter(requireContext(), items)
        snkRecyclerView.adapter = sneakerAdaptet
    }


    private fun refreshAdapterDepartment(items: ArrayList<Department>) {
        val departmentAdapter = DepartmentAdapter(items)
        dpRecyclerView.adapter = departmentAdapter
    }

    private fun getEssentials(): ArrayList<Essential> {
        val items = ArrayList<Essential>()

        for (i in 0..20) {
            items.add(Essential("Ocules", R.drawable.product_1))
            items.add(Essential("Ocules", R.drawable.img_1))
            items.add(Essential("Ocules", R.drawable.img_2))
            items.add(Essential("Ocules", R.drawable.img_3))

        }
        return items
    }


    private fun getSneakers(): ArrayList<Sneakers> {
        val items = ArrayList<Sneakers>()

        for (i in 0..10) {
            items.add(
                Sneakers(
                    R.drawable.sneaker_1,
                    R.drawable.sneaker_1,
                    R.drawable.sneaker_1,
                    R.drawable.sneaker_1
                )
            )
        }

        return items
    }


    private fun getDepartments(): ArrayList<Department> {
        val items = ArrayList<Department>()
        items.add(Department(R.drawable.beauty, "Beauty"))
        items.add(Department(R.drawable.home_kitchen, "Home and Kitchen"))
        items.add(Department(R.drawable.sport_outdoor, "Sports and Outdoors"))
        items.add(Department(R.drawable.electronics, "Electronics"))
        items.add(Department(R.drawable.beauty, "Beauty"))
        items.add(Department(R.drawable.home_kitchen, "Home and Kitchen"))
        items.add(Department(R.drawable.sport_outdoor, "Sports and Outdoors"))
        items.add(Department(R.drawable.electronics, "Electronics"))


        return items
    }

}