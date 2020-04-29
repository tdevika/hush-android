package com.devika.hush.ui.home.equities.stocks

import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.ui.base.UiState
import com.devika.hush.ui.base.getList

@BindingAdapter(value = ["setStocks"])
fun setStocks(
    recycler: RecyclerView,
    uiState: UiState?
) {
    if (recycler.adapter == null) {
        recycler.adapter = StocksAdapter()
    }
    uiState?.let {
        when (uiState) {
            is UiState.Success -> {
                recycler.isVisible = true
                (recycler.adapter as StocksAdapter).submitList(uiState.value.getList())
            }
            else -> recycler.isVisible = false
        }
    }
}