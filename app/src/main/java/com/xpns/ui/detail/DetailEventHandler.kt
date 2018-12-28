package com.xpns.ui.detail

import android.content.Context

class DetailEventHandler(private val context: Context) {

    fun onRetry(searchViewModel: DetailViewModel, url: String) {
        searchViewModel.fetchRepositorySubscribers(url)
    }
}