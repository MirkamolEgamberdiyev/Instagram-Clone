package com.mirkamol.retrofitexample.ui.comment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mirkamol.retrofitexample.R
import com.mirkamol.retrofitexample.adapter.MessageFragmentVPAdapter

class CommentFragment : Fragment(R.layout.fragment_comment) {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewPager)


        tabLayout.setupWithViewPager(viewPager)

        val adapter = MessageFragmentVPAdapter(
            requireActivity().supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        adapter.addFragment(UpdateFragment(), "Updates")
        adapter.addFragment(ChatFragment(), "Messages")
        viewPager.adapter = adapter

    }

}