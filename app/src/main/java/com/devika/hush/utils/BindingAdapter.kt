package com.devika.hush.utils

import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.devika.hush.ui.base.BaseState

@BindingAdapter(value = ["setProgressState"], requireAll = true)
fun setProgressState(
    progressBar: ProgressBar,
    uiState: BaseState?
) {
    uiState?.let { progressBar.isVisible = uiState is BaseState.Loading }
}

@BindingAdapter(value = ["setErrorState"])
fun setErrorState(
    errorView: TextView,
    uiState: BaseState?
) {
    uiState?.let {
        when (uiState) {
            is BaseState.Error -> {
                errorView.isVisible = true
                errorView.text = uiState.message
            }
            else -> {
                errorView.isVisible = false
            }
        }
    }
}
