package com.hush.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hush.ui.findstocks.FindStocksFragment
import com.hush.ui.hushlist.HushListFragment
import com.hush.ui.watchList.WatchlistFragment


class PageAdapter(var fm: FragmentManager?, val noOfTabs: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> HushListFragment()
            1 -> WatchlistFragment()
            2 -> FindStocksFragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return noOfTabs
    }
}