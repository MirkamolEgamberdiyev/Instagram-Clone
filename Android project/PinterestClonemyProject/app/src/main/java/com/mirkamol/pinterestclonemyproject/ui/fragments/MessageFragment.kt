package com.mirkamol.pinterestclonemyproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.google.android.material.tabs.TabLayout
import com.mirkamol.pinterestclonemyproject.R
import com.mirkamol.pinterestclonemyproject.adapter.MessageAdapter


class MessageFragment : Fragment(R.layout.fragment_message) {
    lateinit var viewPager: ViewPager
    lateinit var tabLayout:TabLayout
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)

        val adapter = MessageAdapter(parentFragmentManager)
        adapter.addFragment(ChatUpdateFragment(), "Update")
        adapter.addFragment(ChatMessageFragment(), "Messages")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)



    }
}