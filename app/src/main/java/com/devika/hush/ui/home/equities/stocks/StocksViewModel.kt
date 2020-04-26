package com.devika.hush.ui.home.equities.stocks

import androidx.lifecycle.viewModelScope
import com.devika.hush.data.domain.onError
import com.devika.hush.data.domain.onSuccess
import com.devika.hush.ui.base.BaseViewModel
import com.devika.hush.ui.base.UiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class StocksViewModel @Inject constructor(
    private val stocksUseCase: StocksUseCase
) : BaseViewModel<UiState>() {
    init {
        viewModelScope.launch {
            stocksUseCase.execute(Unit).run {
                onSuccess { uiState.value = UiState.Success(it) }
                onError { uiState.value = UiState.Error(it.message) }
            }
        }
    }
}

