package com.devika.hush.ui.portfolio

import androidx.lifecycle.*
import com.devika.hush.base.BaseViewModel
import com.devika.hush.data.model.Portfolio
import com.devika.hush.utils.result.Results
import kotlinx.coroutines.launch
import javax.inject.Inject

class PortfolioViewModel @Inject constructor(
    portfolioUseCase: PortfolioUseCase
) : BaseViewModel() {
    var portfolioResults: LiveData<List<Portfolio>> = MutableLiveData<List<Portfolio>>()

    init {
        viewModelScope.launch {
            processSearchResult(portfolioUseCase(Unit))
        }
    }
    private fun processSearchResult(result: Results<LiveData<List<Portfolio>>>) {
        portfolioResults = (result as? Results.Success)?.data ?: liveData { emptyArray<Portfolio>() }
    }
}