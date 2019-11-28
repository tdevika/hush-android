package com.hush.ui.watchList

import android.os.Bundle
import android.view.View
import com.hush.R
import com.hush.databinding.FragmentWatchlistBinding
import com.hush.ui.base.BaseFragment

class WatchlistFragment : BaseFragment<FragmentWatchlistBinding, WatchlistFragmentViewModel>() {

    override fun layoutId() = R.layout.fragment_watchlist

    override fun getViewModelClass() = WatchlistFragmentViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
