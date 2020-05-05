package com.devika.hush.ui.home.equities

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devika.hush.R
import com.devika.hush.databinding.FragmentEquitiesBinding
import com.devika.hush.injection.component.injector
import com.devika.hush.ui.home.equities.portfolio.PortfolioFragment
import com.devika.hush.ui.home.equities.stocks.StocksFragment
import com.devika.hush.ui.home.equities.watchlist.WatchListFragment
import com.devika.hush.utils.EventObserver
import com.devika.hush.utils.HushViewModelFactory
import com.devika.hush.utils.viewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class EquitiesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: HushViewModelFactory

    private lateinit var binding: FragmentEquitiesBinding
    private lateinit var viewModel: EquitiesViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEquitiesBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = viewModelProvider(viewModelFactory)
        setObserver()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
        setTabLayout()
    }

    private fun setTabLayout() {
        binding.pager.adapter = EquitiesTabAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> tab.text = "PORTFOLIO"
                1 -> tab.text = "WATCHLIST"
                2 -> tab.text = "STOCKS"

            }
        }.attach()
    }

    private fun setToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        setHasOptionsMenu(true)
    }

    private fun setObserver() {
        viewModel.navigateToDetail.observe(viewLifecycleOwner, EventObserver { symbol ->
            findNavController().navigate(
                EquitiesFragmentDirections.actionEquitiesFragmentToDetailFragment(symbol)
            )
        })
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
