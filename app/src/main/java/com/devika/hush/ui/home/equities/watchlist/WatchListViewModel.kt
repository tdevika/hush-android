package com.devika.hush.ui.home.equities.watchlist

import androidx.lifecycle.viewModelScope
import com.devika.hush.data.domain.onError
import com.devika.hush.data.domain.onLoading
import com.devika.hush.data.domain.onSuccess
import com.devika.hush.ui.base.BaseViewModel
import com.devika.hush.ui.base.UiState
import javax.inject.Inject
import kotlinx.coroutines.launch

class WatchListViewModel @Inject constructor(private val watchListUseCase: WatchListUseCase) :
    BaseViewModel<UiState>() {
    init {
        viewModelScope.launch {
            watchListUseCase(Unit).run {
                onLoading { uiState.value = UiState.Loading }
                onSuccess { uiState.value = UiState.Success(it) }
                onError { uiState.value = UiState.Error(it.message) }
            }
        }
    }
}
