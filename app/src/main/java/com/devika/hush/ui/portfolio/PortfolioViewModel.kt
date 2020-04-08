package com.devika.hush.ui.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.model.Stocks
import com.devika.hush.data.repository.HushRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PortfolioViewModel @Inject constructor(val hushRepository: HushRepository) : ViewModel() {

    private val _portfolioData = MutableLiveData<List<Stocks>>()

    val portfolioData: LiveData<List<Stocks>> = _portfolioData

    init {
        getportfolioData()
    }

    private fun getportfolioData() {
        viewModelScope.launch(Dispatchers.IO) {
            _portfolioData.postValue(hushRepository.getPortfolio())
        }
    }
}