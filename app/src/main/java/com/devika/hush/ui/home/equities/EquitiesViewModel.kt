package com.devika.hush.ui.home.equities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.domain.onError
import com.devika.hush.data.domain.onLoading
import com.devika.hush.data.domain.onSuccess
import com.devika.hush.ui.base.BaseState
import com.devika.hush.ui.base.BaseViewModel
import com.devika.hush.ui.base.UiState
import com.devika.hush.ui.home.equities.portfolio.PortfolioUseCase
import com.devika.hush.ui.home.equities.stocks.StocksUseCase
import com.devika.hush.ui.home.equities.watchlist.WatchListUseCase
import com.devika.hush.utils.Event
import javax.inject.Inject
import kotlinx.coroutines.launch

class EquitiesViewModel @Inject constructor(
    private val portfolioUseCase: PortfolioUseCase,
    private val stocksUseCase: StocksUseCase,
    private val watchListUseCase: WatchListUseCase

) : BaseViewModel(), ItemClickListener {

    private val portfolioUiState: MutableLiveData<BaseState> = MutableLiveData()
    fun portfolioUiState(): LiveData<BaseState> = portfolioUiState

    private val stockUiState: MutableLiveData<BaseState> = MutableLiveData()
    fun stockUiState(): LiveData<BaseState> = stockUiState

    private val watchListUiState: MutableLiveData<BaseState> = MutableLiveData()
    fun watchListUiState(): LiveData<BaseState> = watchListUiState

    private val _navigateToDetail = MutableLiveData<Event<String>>()
    val navigateToDetail: LiveData<Event<String>>
    get() = _navigateToDetail

    init {
        viewModelScope.launch {
            portfolioUseCase(Unit).run {
                onLoading { portfolioUiState.value = BaseState.Loading }
                onSuccess { portfolioUiState.value = UiState.Success(it) }
                onError { portfolioUiState.value = BaseState.Error(it.message) }
            }
            stocksUseCase(Unit).run {
                onLoading { stockUiState.value = BaseState.Loading }
                onSuccess { stockUiState.value = UiState.Success(it) }
                onError { stockUiState.value = BaseState.Error(it.message) }
            }
            watchListUseCase(Unit).run {
                onLoading { watchListUiState.value = BaseState.Loading }
                onSuccess { watchListUiState.value = UiState.Success(it) }
                onError { watchListUiState.value = BaseState.Error(it.message) }
            }
        }
    }

    override fun onItemClick(symbol: String) {
        _navigateToDetail.value = Event(symbol)
    }
}

interface ItemClickListener {
    fun onItemClick(symbol: String)
}
