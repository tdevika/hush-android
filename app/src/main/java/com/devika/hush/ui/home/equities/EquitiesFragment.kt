package com.devika.hush.ui.home.equities

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.databinding.FragmentEquitiesBinding
import com.devika.hush.ui.base.BaseFragment
import com.devika.hush.ui.home.equities.portfolio.PortfolioFragment
import com.devika.hush.ui.home.equities.stocks.StocksFragment
import com.devika.hush.ui.home.equities.watchlist.WatchListFragment
import com.google.android.material.tabs.TabLayoutMediator

class EquitiesFragment : BaseFragment<FragmentEquitiesBinding, EquitiesViewModel>() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun layoutId() = R.layout.fragment_equities

    override fun getViewModelClass() = EquitiesViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding.pager.adapter = EquitiesTabAdapter(this)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "PORTFOLIO"
                }
                1 -> {
                    tab.text = "WATCHLIST"
                }
                2 -> {
                    tab.text = "STOCKS"
                }
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
    }
}

class EquitiesTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PortfolioFragment()
            1 -> WatchListFragment()
            else -> StocksFragment()
        }
    }
}
