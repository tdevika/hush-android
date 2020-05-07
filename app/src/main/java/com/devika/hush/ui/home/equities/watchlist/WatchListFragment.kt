package com.devika.hush.ui.home.equities.watchlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.devika.hush.databinding.FragmentWatchListBinding
import com.devika.hush.injection.component.injector
import com.devika.hush.ui.home.equities.EquitiesViewModel
import com.devika.hush.utils.HushViewModelFactory
import com.devika.hush.utils.parentViewModelProvider
import javax.inject.Inject

class WatchListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: HushViewModelFactory

    private lateinit var binding: FragmentWatchListBinding
    private lateinit var viewModel: EquitiesViewModel
    private lateinit var watchListAdapter: WatchListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWatchListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToModel()
        setHasOptionsMenu(true)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        watchListAdapter = WatchListAdapter(viewModel)
        binding.recycler.adapter = watchListAdapter
    }

    private fun subscribeToModel() {
        viewModel = parentViewModelProvider(viewModelFactory)
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
