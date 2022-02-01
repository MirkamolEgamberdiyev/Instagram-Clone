package com.mirkamol.fragmentbyrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mirkamol.fragmentbyrecyclerview.adapters.ViewPagerAdapter
import com.mirkamol.fragmentbyrecyclerview.fragment.ContactFragment
import com.mirkamol.fragmentbyrecyclerview.fragment.PostFragment
import com.mirkamol.fragmentbyrecyclerview.fragment.UserFragment

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var contactFragment: ContactFragment
    private lateinit var postFragment: PostFragment
    private lateinit var userFragment: UserFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.vp_main)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        contactFragment = ContactFragment()
        postFragment = PostFragment()
        userFragment = UserFragment()

        viewPagerAdapter.addFragment(contactFragment, "Contact")
        viewPagerAdapter.addFragment(userFragment, "User")
        viewPagerAdapter.addFragment(postFragment, "Post")


        viewPager.adapter = viewPagerAdapter


        tabLayout = findViewById(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)


    }
}