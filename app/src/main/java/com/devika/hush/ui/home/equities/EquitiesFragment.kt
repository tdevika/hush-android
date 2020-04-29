package com.devika.hush.ui.home.equities

import android.content.Context
import android.os.Bundle
import android.view.View
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
        binding.pager.adapter = DemoCollectionAdapter(this)
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
}

class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PortfolioFragment()
            1 -> WatchListFragment()
            else -> StocksFragment()
        }
    }
}
