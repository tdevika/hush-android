package com.hush.ui.hushlist

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.hush.data.model.HushItems
import com.hush.data.repository.XpnsRepository
import com.hush.ui.base.BaseViewModel
import com.hush.utils.DataWrapper
import java.util.*
import javax.inject.Inject

class HushListFragmentViewModel @Inject constructor(private val xpnsRepository: XpnsRepository) : BaseViewModel() {
    var repositoriesLiveData = MutableLiveData<DataWrapper<HushItems>>()
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
