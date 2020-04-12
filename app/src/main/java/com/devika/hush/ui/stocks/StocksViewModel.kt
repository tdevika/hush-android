package com.devika.hush.ui.stocks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.model.Stocks
import com.devika.hush.data.repository.HushRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class StocksViewModel @Inject constructor(
    private val hushRepository: HushRepository
) : ViewModel() {

    var stockList: LiveData<List<Stocks>> = hushRepository.getStocksList()

    fun addToWatchList(stocks: Stocks) {
        viewModelScope.launch(Dispatchers.IO) {
            hushRepository.addToWatchList(stocks)
        }
    }
}

