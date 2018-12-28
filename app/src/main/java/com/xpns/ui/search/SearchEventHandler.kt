package com.xpns.ui.search

import android.content.Context
import android.content.Intent
import com.xpns.data.model.Item
import com.xpns.ui.detail.DetailActivity
import com.xpns.utils.Constants

class SearchEventHandler(private val context: Context) {

    fun onItemClick(item: Item) {
        val detailsIntent = Intent(context, DetailActivity::class.java)
        detailsIntent.putExtra(Constants.EXTRA_SUBSCRIBERS_URL, item.subscribersUrl)
        detailsIntent.putExtra(Constants.EXTRA_REPO_NAME, item.name)
        context.startActivity(detailsIntent)
    }

    fun onRetrySearch(searchViewModel: SearchViewModel, query: String) {
        searchViewModel.searchRepository(query)
    }
}