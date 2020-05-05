package com.devika.hush.ui.home.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.domain.onError
import com.devika.hush.data.domain.onLoading
import com.devika.hush.data.domain.onSuccess
import com.devika.hush.data.model.StockDetails
import com.devika.hush.ui.base.BaseState
import com.devika.hush.ui.base.BaseViewModel
import com.devika.hush.ui.base.UiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val detailsUseCase: DetailsUseCase) :
    BaseViewModel() {
    private val _stockDetails =  MutableLiveData<StockDetails>()
    fun stockDetails(): LiveData<StockDetails> = _stockDetails

    val _isAddToWatchlist = MutableLiveData<Boolean>()
    val isAddToWatchlist: LiveData<Boolean> = _isAddToWatchlist

    fun getStockDetails(symbol: String) {
        viewModelScope.launch {
            detailsUseCase(symbol).run {
                onLoading { uiState.value = BaseState.Loading }
                onSuccess {
                    uiState.value = UiState.Success(Unit)
                    _stockDetails.value = it
                }
                onError { uiState.value = BaseState.Error(it.message) }
            }
        }
    }

    fun addToWatchList(){

    }

}