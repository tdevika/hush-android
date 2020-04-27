package com.devika.hush.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.domain.RefreshCacheUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val refreshCacheUseCase: RefreshCacheUseCase
) : ViewModel() {
    init {
        viewModelScope.launch {
            refreshCacheUseCase(Unit)
        }
    }
}
