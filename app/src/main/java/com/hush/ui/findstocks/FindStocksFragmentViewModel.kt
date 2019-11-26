package com.hush.ui.findstocks

import androidx.lifecycle.MutableLiveData
import com.hush.data.model.Portfolio
import com.hush.data.repository.HushRepository
import com.hush.ui.base.BaseViewModel
import com.hush.utils.DataWrapper
import dagger.Provides
import javax.inject.Inject

class FindStocksFragmentViewModel @Inject constructor(hushRepository: HushRepository) : BaseViewModel()  {
var repositoryLiveData=MutableLiveData<DataWrapper<List<Portfolio>>>()
    init {
        displayLoader(true)
        hushRepository.getStockList(repositoryLiveData)
    }
}