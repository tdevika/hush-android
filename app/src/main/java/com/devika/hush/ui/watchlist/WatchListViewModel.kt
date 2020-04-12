package com.devika.hush.ui.watchlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.model.Stocks
import com.devika.hush.data.repository.HushRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WatchListViewModel @Inject constructor(val hushRepository: HushRepository) : ViewModel() {
    private val _watchList = MutableLiveData<List<Stocks>?>()
    val stocks: LiveData<List<Stocks>?> = _watchList


    init {
        getWatchList()
    }

    private fun getWatchList() {
        viewModelScope.launch(Dispatchers.IO) {
            _watchList.postValue(hushRepository.getWatchList())
        }
    }

    fun deleteWatchList(symbol: String) {
        viewModelScope.launch(Dispatchers.IO) { hushRepository.deleteWatchList(symbol) }
    }
}