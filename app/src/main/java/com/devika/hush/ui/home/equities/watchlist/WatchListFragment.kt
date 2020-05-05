package com.devika.hush.ui.home.equities.watchlist

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.databinding.FragmentWatchListBinding
import com.devika.hush.ui.base.BaseFragment

class WatchListFragment : BaseFragment<FragmentWatchListBinding, WatchListViewModel>() {

    lateinit var watchListAdapter: WatchListAdapter
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun getViewModelClass(): Class<WatchListViewModel> = WatchListViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_watch_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        subscribeToModel()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        watchListAdapter = WatchListAdapter()
        binding.recycler.adapter = watchListAdapter
    }

    private fun subscribeToModel() {
        binding.watchListViewModel = viewModel
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                watchListAdapter.filter.filter(newText)
                return false
            }
        })
        return super.onOptionsItemSelected(item)
    }
}
