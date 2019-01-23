package com.xpns.ui.xpnslist

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.xpns.data.model.XpnsItems
import com.xpns.data.repository.XpnsRepository
import com.xpns.ui.base.BaseViewModel
import com.xpns.utils.DataWrapper
import java.util.*
import javax.inject.Inject

class XpnsListFragmentViewModel @Inject constructor(private val xpnsRepository: XpnsRepository) : BaseViewModel() {
    var repositoriesLiveData = MutableLiveData<DataWrapper<XpnsItems>>()
    var amount: ObservableField<String> = ObservableField()
    var note: ObservableField<String> = ObservableField()
    var date: ObservableField<String> = ObservableField()
    var category: ObservableField<String> = ObservableField()
    private val calendar = Calendar.getInstance()

    init {
        displayLoader(true)
        xpnsRepository.getExpenses(repositoriesLiveData)
    }
}
