package com.devika.hush.ui.home.equities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.domain.onError
import com.devika.hush.data.domain.onLoading
import com.devika.hush.data.domain.onSuccess
import com.devika.hush.ui.base.BaseViewModel
import com.devika.hush.ui.base.UiState
import com.devika.hush.ui.home.equities.portfolio.PortfolioUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class EquitiesViewModel @Inject constructor(
    private val portfolioUseCase: PortfolioUseCase

) : BaseViewModel<UiState>(), ItemClickListener {

    private val _navigateToDetail = MutableLiveData<String>()
    val navigateToDetail: LiveData<String> = _navigateToDetail

    private val portfolioUiState: MutableLiveData<UiState> = MutableLiveData()
    fun portfolioUiState(): LiveData<UiState> = portfolioUiState

    init {
        viewModelScope.launch {
            portfolioUseCase(Unit).run {
                onLoading { portfolioUiState.value = UiState.Loading }
                onSuccess { portfolioUiState.value = UiState.Success(it) }
                onError { portfolioUiState.value = UiState.Error(it.message) }
            }
        }
    }

    override fun onItemClick(symbol: String) {
        _navigateToDetail.postValue(symbol)
    }
}

interface ItemClickListener {
    fun onItemClick(symbol: String)
}
