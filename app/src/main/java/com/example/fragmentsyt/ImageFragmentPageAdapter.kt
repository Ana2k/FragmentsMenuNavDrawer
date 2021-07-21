package com.example.fragmentsyt

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter

//ViewPager is deprecated
//we can use the gesture module for creating swips but
//may need this tech to update older values
class ImageFragmentPageAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){
    override fun getCount()=2
    //strange i think tells of the number of pages involved with pagerAdapter

    override fun getItem(position: Int): Fragment {
        return when(position){
            0->FirstImageFragment.newInstance()
            1->SecondImageFragment.newInstance()
            else->FirstImageFragment.newInstance()
        }
    }

}