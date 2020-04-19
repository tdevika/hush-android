package com.devika.hush.ui.home.equities.portfolio

import androidx.lifecycle.*
import com.devika.hush.data.domain.PortfolioUseCase
import com.devika.hush.ui.base.BaseViewModel
import com.devika.hush.data.model.Portfolio
import com.devika.hush.utils.result.Results
import kotlinx.coroutines.launch
import javax.inject.Inject

class PortfolioViewModel @Inject constructor(
    portfolioUseCase: PortfolioUseCase
) : BaseViewModel() {
    var portfolioResults: LiveData<List<Portfolio>> = MutableLiveData()

    init {
        viewModelScope.launch {
            processSearchResult(portfolioUseCase(Unit))
        }
    }
    private fun processSearchResult(result: Results<LiveData<List<Portfolio>>>) {
        portfolioResults = (result as? Results.Success)?.data ?: liveData { emptyArray<Portfolio>() }
    }
}