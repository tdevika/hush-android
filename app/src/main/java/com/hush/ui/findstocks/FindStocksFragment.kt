package com.hush.ui.findstocks

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hush.R
import com.hush.data.model.Portfolio
import com.hush.databinding.FragmentStocksListBinding
import com.hush.ui.base.BaseFragment
import com.hush.utils.DataWrapper
import javax.inject.Inject

class FindStocksFragment : BaseFragment<FragmentStocksListBinding, FindStocksFragmentViewModel>() {
    @Inject
    lateinit var findStocksAdapter: FindStocksAdapter

    override fun getViewModelClass() = FindStocksFragmentViewModel::class.java

    override fun layoutId() = R.layout.fragment_stocks_list
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        subscribeToModel()
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
        viewModel.repositoryLiveData.observe(this, subscribersObserver())
        binding.setLifecycleOwner(this)


    }

    private fun subscribersObserver(): Observer<DataWrapper<List<Portfolio>>> {
        return Observer {
            //viewModel.displayLoader(false)
            /*if(binding.progressBar.visibility == View.INVISIBLE){
                View.GONE
            }*/
            viewModel.displayLoader(false)
            it?.let {
                if (!it.isError) {
                    findStocksAdapter.updateData(sortList(it.data!!))
                }
            }
        }

    }

    private fun sortList(data: List<Portfolio>): ArrayList<Portfolio> {
        return data.filter { !it.close_price.isNullOrBlank() } as ArrayList<Portfolio>

    }

    private fun initializeUI() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = findStocksAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.search_item)
        val searchView: SearchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                findStocksAdapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.search_item) {

        }
        return true
    }
}