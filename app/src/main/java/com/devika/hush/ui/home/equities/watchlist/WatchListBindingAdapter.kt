package com.devika.hush.ui.home.equities.watchlist

import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.ui.base.BaseState
import com.devika.hush.ui.base.UiState
import com.devika.hush.ui.base.getList

@BindingAdapter(value = ["setWatchlist"])
fun setWatchlist(
    recyclerView: RecyclerView,
    uiState: BaseState?
) {
    uiState?.let {
        when (uiState) {
            is UiState.Success -> {
                recyclerView.isVisible = true
                (recyclerView.adapter as WatchListAdapter).submitList(uiState.value.getList())
            }
            else -> recyclerView.isVisible = false
        }
    }
}
