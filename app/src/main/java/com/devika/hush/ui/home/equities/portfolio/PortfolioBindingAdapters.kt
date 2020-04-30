package com.devika.hush.ui.home.equities.portfolio

import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.data.model.Portfolio
import com.devika.hush.ui.base.UiState
import com.devika.hush.ui.base.getList

@BindingAdapter(value = ["setPortfolio"])
fun setPortfolio(
    recyclerView: RecyclerView,
    uiState: UiState?
) {
    uiState?.let {
        when (uiState) {
            is UiState.Success -> {
                recyclerView.isVisible = true
                (recyclerView.adapter as PortfolioAdapter).submitList(uiState.value.getList())
            }
            else -> recyclerView.isVisible = false
        }
    }
}
