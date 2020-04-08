package com.devika.hush.ui.stocks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.model.Stocks
import com.devika.hush.data.repository.HushRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class StocksViewModel @Inject constructor(private val hushRepository: HushRepository) : ViewModel() {

    private val _allStockList = MutableLiveData<List<Stocks>>()

    val stockList: LiveData<List<Stocks>> = _allStockList

    init {
        getStockList()
    }

    private fun getStockList() {
        viewModelScope.launch(Dispatchers.IO) {
            _allStockList.postValue(hushRepository.getAllStocksList())
        }
    }

    fun addToWatchList(stocks: Stocks) {
      viewModelScope.launch (Dispatchers.IO){
          hushRepository.addToWatchList(stocks)
      }
    }
}

