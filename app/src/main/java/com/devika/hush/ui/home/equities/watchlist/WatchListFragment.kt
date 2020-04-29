package com.devika.hush.ui.home.equities.watchlist

import android.content.Context
import android.os.Bundle
import android.view.View
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.databinding.FragmentWatchListBinding
import com.devika.hush.ui.base.BaseFragment

class WatchListFragment : BaseFragment<FragmentWatchListBinding, WatchListViewModel>() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun getViewModelClass(): Class<WatchListViewModel> = WatchListViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_watch_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToModel()
    }

    private fun subscribeToModel() {
        binding.watchListViewModel = viewModel
    }
}
