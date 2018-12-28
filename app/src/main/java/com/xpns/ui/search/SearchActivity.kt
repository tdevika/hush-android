package com.xpns.ui.search

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import com.xpns.R
import com.xpns.data.model.RepositoriesResponse
import com.xpns.ui.base.BaseActivity
import com.xpns.utils.Constants
import com.xpns.utils.DataWrapper
import com.xpns.databinding.ActivitySearchBinding
import javax.inject.Inject

class SearchActivity : BaseActivity<ActivitySearchBinding, SearchViewModel>() {

    @Inject
    lateinit var searchAdapter: SearchAdapter

    @Inject
    lateinit var eventHandler: SearchEventHandler

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var searchView: SearchView

    override fun getViewModelClass() = SearchViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.activity_search
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeUI()
        subscribeToModel()
    }

    private fun initializeUI() {
        setSupportActionBar(binding.toolbar)
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            adapter = searchAdapter
        }
    }

    private fun subscribeToModel() {
        binding.searchViewModel = viewModel
        binding.eventHandler = eventHandler
        viewModel.repositoriesLiveData.observe(this, repositoriesObserver())
        binding.setLifecycleOwner(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchActionMenuItem = menu.findItem(R.id.menu_search)
        searchView = searchActionMenuItem.actionView as SearchView
        searchView.setOnQueryTextListener(onQueryTextListener(searchActionMenuItem))
        searchActionMenuItem.expandActionView()
        return true
    }

    private fun onQueryTextListener(searchActionMenuItem: MenuItem): SearchView.OnQueryTextListener {
        return object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (!searchView.isIconified) {
                    searchView.isIconified = true
                }
                searchRepository(query)
                binding.recyclerView.scrollToPosition(0)
                binding.toolbar.title = query
                searchActionMenuItem.collapseActionView()
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                return false
            }
        }
    }

    private fun searchRepository(query: String) {
        binding.query = query
        viewModel.searchRepository(query)
    }

    private fun repositoriesObserver(): Observer<DataWrapper<RepositoriesResponse>> {
        return Observer {
            viewModel.displayLoader(false)
            it?.let {
                if (!it.isError) {
                    if (it.data?.items?.size != 0) {
                        searchAdapter.updateData(it.data!!.items)
                        viewModel.setErrorMessage(false, Constants.EMPTY_MESSAGE)
                    } else {
                        viewModel.setErrorMessage(true, getString(R.string.empty_search_result))
                    }
                } else {
                    viewModel.setErrorMessage(it.isError, it.errorMessage)
                }
            }
        }
    }
}