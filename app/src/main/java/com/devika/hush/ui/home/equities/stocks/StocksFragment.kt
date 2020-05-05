package com.devika.hush.ui.home.equities.stocks

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.databinding.FragmentStocksBinding
import com.devika.hush.ui.base.BaseFragment

class StocksFragment : BaseFragment<FragmentStocksBinding, StocksViewModel>() {
    lateinit var stocksAdapter: StocksAdapter
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun getViewModelClass(): Class<StocksViewModel> = StocksViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_stocks

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToModel()
        setHasOptionsMenu(true)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        stocksAdapter = StocksAdapter()
        binding.recycler.adapter = stocksAdapter
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                stocksAdapter.filter.filter(newText)
                return false
            }
        })
        return super.onOptionsItemSelected(item)
    }
}
