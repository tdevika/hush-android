package com.hush.ui.hushlist

import androidx.lifecycle.MutableLiveData
import com.hush.data.model.Portfolio
import com.hush.data.repository.HushRepository
import com.hush.ui.base.BaseViewModel
import com.hush.utils.DataWrapper
import javax.inject.Inject

class HushListFragmentViewModel @Inject constructor(hushRepository: HushRepository) : BaseViewModel() {
    var repositoriesLiveData = MutableLiveData<DataWrapper<List<Portfolio>>>()

    init {
       // displayLoader(true)
        hushRepository.getPortfolio(repositoriesLiveData)
    }
}
