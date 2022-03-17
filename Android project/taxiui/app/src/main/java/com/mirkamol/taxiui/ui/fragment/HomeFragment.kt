package com.mirkamol.taxiui.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mirkamol.taxiui.ui.CitySelectionBottomSheet
import com.mirkamol.taxiui.ui.CitySelectionBottomSheet.Companion.ACTION_FROM
import com.mirkamol.taxiui.ui.CitySelectionBottomSheet.Companion.ACTION_TO
import com.mirkamol.taxiui.R
import com.mirkamol.taxiui.adapter.SlinderAdapter
import com.mirkamol.taxiui.model.Banner

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var isDrawerOpen = false
    private val adapter by lazy { SlinderAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI(view)
    }

    private fun setupUI(view: View) {
        val btnMenu = view.findViewById<ImageView>(R.id.btn_menu)
        val drawerLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)
        val slider = view.findViewById<ViewPager2>(R.id.slider)
        val tvFrom = view.findViewById<TextView>(R.id.tv_from)
        val tvTo = view.findViewById<TextView>(R.id.tv_to)
        var indicator = view.findViewById<TabLayout>(R.id.tabIndicator)

        tvFrom.setOnClickListener {
           openRegionSheet(ACTION_FROM)
        }
        tvTo.setOnClickListener {
            CitySelectionBottomSheet(ACTION_TO)
        }

        setData()
        slider.adapter = adapter


        TabLayoutMediator(indicator, slider){_, _, ->}.attach()

        btnMenu.setOnClickListener {
            drawerLayout.open()
        }
    }

    private fun openRegionSheet(type:Int) {
        val dialog = CitySelectionBottomSheet(type)
        dialog.show(requireActivity().supportFragmentManager, null)

    }

    private fun setData() {
        var list = ArrayList<Banner>()
        list.add(
            Banner(
            "https://media.istockphoto.com/photos/3d-yellow-taxi-picture-id492362277?s=2048x2048",
            "Themes")
        )
        list.add(
            Banner(
            "https://media.istockphoto.com/photos/3d-yellow-taxi-picture-id492362277?s=2048x2048",
            "Themes")
        )
        list.add(
            Banner(
            "https://media.istockphoto.com/photos/3d-yellow-taxi-picture-id492362277?s=2048x2048",
            "Themes")
        )
        list.add(
            Banner(
            "https://media.istockphoto.com/photos/3d-yellow-taxi-picture-id492362277?s=2048x2048",
            "Themes")
        )
        list.add(
            Banner(
            "https://media.istockphoto.com/photos/3d-yellow-taxi-picture-id492362277?s=2048x2048",
            "Themes")
        )

        adapter.submitData(list)



    }
}