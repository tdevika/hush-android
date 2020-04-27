package com.devika.hush.ui.home.equities.stocks

import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.ui.base.UiState
import com.devika.hush.ui.base.getList

@BindingAdapter(value = ["setData"])
fun setData(recycler: RecyclerView, uiState: UiState) {
    if (recycler.adapter == null) {
        recycler.adapter = StocksAdapter()
    }
    uiState.let {
        when (uiState) {
            is UiState.Success -> {
                recycler.isVisible = true
                (recycler.adapter as StocksAdapter).submitList(uiState.value.getList())
            }
            else -> recycler.isVisible = false

        }
    }
}

@BindingAdapter(value = ["setProgressState"], requireAll = true)
fun setProgressState(
    progressBar: ProgressBar,
    uiState: UiState
) {
    uiState?.let {
        progressBar.isVisible = uiState is UiState.Loading
    }

}

@BindingAdapter(value = ["setErrorState"])
fun setErrorState(
    errorText: TextView,
    uiState: UiState
) {
    uiState?.let {
        when (uiState) {
            is UiState.Error -> {
                errorText.isVisible = true
                errorText.text = uiState.message
            }
            else -> errorText.isVisible = false
        }
    }

}