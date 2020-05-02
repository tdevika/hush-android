package com.devika.hush.ui.home.details

import androidx.lifecycle.viewModelScope
import com.devika.hush.ui.base.BaseViewModel
import com.devika.hush.ui.base.UiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(detailsUseCase: DetailsUseCase) : BaseViewModel<UiState>() {
    init {
        viewModelScope.launch {

        }
    }

}