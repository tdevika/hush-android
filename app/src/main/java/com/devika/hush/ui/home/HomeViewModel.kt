package com.devika.hush.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devika.hush.data.domain.RefreshCacheUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch

class HomeViewModel @Inject constructor(
    private val refreshCacheUseCase: RefreshCacheUseCase
) : ViewModel() {
    init {
        viewModelScope.launch {
            refreshCacheUseCase(Unit)
        }
    }
}
