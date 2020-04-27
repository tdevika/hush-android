package com.devika.hush.ui.home.equities.watchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.repository.HushRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WatchListViewModel @Inject constructor(private val hushRepository: HushRepository) :
    ViewModel() {

    fun deleteWatchList(symbol: String) {
        viewModelScope.launch(Dispatchers.IO) { hushRepository.deleteWatchList(symbol) }
    }
}
