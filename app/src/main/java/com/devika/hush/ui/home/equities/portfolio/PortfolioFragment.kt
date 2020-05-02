package com.devika.hush.ui.home.equities.portfolio

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.databinding.FragmentPortfolioBinding
import com.devika.hush.ui.base.BaseFragment
import com.devika.hush.ui.home.equities.EquitiesViewModel

class PortfolioFragment : BaseFragment<FragmentPortfolioBinding, EquitiesViewModel>() {

    private lateinit var portfolioAdapter: PortfolioAdapter
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun layoutId() = R.layout.fragment_portfolio

    override fun getViewModelClass() = EquitiesViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToModel()
        setHasOptionsMenu(true)
        setRecyclerView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                portfolioAdapter.filter.filter(newText)
                return false
            }
        })
        return super.onOptionsItemSelected(item)
    }

    private fun setRecyclerView() {
        portfolioAdapter = PortfolioAdapter(viewModel)
        binding.recycler.adapter = portfolioAdapter
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
    }

}
