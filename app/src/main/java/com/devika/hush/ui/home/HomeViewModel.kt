package com.devika.hush.ui.home

import androidx.lifecycle.viewModelScope
import com.devika.hush.data.domain.EquitiesUseCase
import com.devika.hush.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    equitiesUseCase: EquitiesUseCase
) : BaseViewModel() {
    init {
        viewModelScope.launch {
            equitiesUseCase(Unit)
        }
    }
}
