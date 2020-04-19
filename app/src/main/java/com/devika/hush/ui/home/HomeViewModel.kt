package com.devika.hush.ui.home

import androidx.lifecycle.viewModelScope
import com.devika.hush.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    homeDataUseCase: HomeDataUseCase
) : BaseViewModel() {
    init {
        viewModelScope.launch {
            homeDataUseCase(Unit)
        }
    }
}
