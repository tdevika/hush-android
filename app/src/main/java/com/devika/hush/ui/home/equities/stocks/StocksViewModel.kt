package com.devika.hush.ui.home.equities.stocks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.model.Stock
import com.devika.hush.data.model.WatchList
import com.devika.hush.data.repository.HushRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class StocksViewModel @Inject constructor(
    private val hushRepository: HushRepository
) : ViewModel() {

    var stockList: LiveData<List<Stock>> = hushRepository.getStocksList()

    fun addToWatchList(watchList: WatchList) {
        viewModelScope.launch(Dispatchers.IO) {
            hushRepository.addToWatchList(watchList)
        }
    }

}

