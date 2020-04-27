package com.devika.hush.ui.home.equities.portfolio

import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.data.model.Portfolio
import com.devika.hush.ui.base.UiState
import com.devika.hush.ui.base.getList

@BindingAdapter(value = ["setState"])
fun setData(
    recyclerView: RecyclerView,
    uiState: UiState?
) = uiState?.let {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = PortfolioAdapter()
    }
    when (uiState) {
        is UiState.Success -> {

            recyclerView.isVisible = true
            (recyclerView.adapter as PortfolioAdapter).submitList(uiState.value.getList<Portfolio>())
        }
        else -> recyclerView.isVisible = false
    }
}

@BindingAdapter(value = ["setProgressState"], requireAll = true)
fun setProgressState(
    progressBar: ProgressBar,
    uiState: UiState?
) {
    uiState?.let { progressBar.isVisible = uiState is UiState.Loading }
}

@BindingAdapter(value = ["setErrorState"])
fun setErrorState(
    errorView: TextView,
    uiState: UiState?
) = uiState?.let {
    when (uiState) {
        is UiState.Error -> {
            errorView.isVisible = true
            errorView.text = uiState.message
        }
        else -> {
            errorView.isVisible = false
        }
    }
}
