package com.devika.hush.ui.home.equities.portfolio

import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.data.model.Portfolio


@BindingAdapter(value = ["portfolioItems"], requireAll = true)
fun portfolioItems(
    recyclerView: RecyclerView,
    list: List<Portfolio>?
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = PortfolioAdapter()
    }
    if (list.isNullOrEmpty()) {
        recyclerView.isVisible = false
    } else {
        recyclerView.isVisible = true
        (recyclerView.adapter as PortfolioAdapter).submitList(list)
    }
}
