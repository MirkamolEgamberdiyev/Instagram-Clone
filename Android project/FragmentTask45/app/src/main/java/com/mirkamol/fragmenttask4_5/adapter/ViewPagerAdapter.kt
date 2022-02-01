package com.example.fragmenttask5.adapter

import androidx.fragment.app.*

class ViewPagerAdapter(var fragment: ArrayList<Fragment>, var fragmentManager: FragmentManager, var fragmentTitle : ArrayList<String>):
    FragmentStatePagerAdapter(fragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return fragment.size
    }

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitle[position]
    }

}