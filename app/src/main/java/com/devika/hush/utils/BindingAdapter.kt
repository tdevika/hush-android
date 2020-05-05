package com.devika.hush.utils

import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.devika.hush.ui.base.UiState

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
) {
    uiState?.let {
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
}
