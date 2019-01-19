package com.xpns.ui.home

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.xpns.data.model.XpnsItems
import com.xpns.data.repository.XpnsRepository
import com.xpns.injection.scope.ActivityScope
import com.xpns.ui.base.BaseViewModel
import com.xpns.ui.themeswitcher.ThemeSwitcherDialogFragment
import com.xpns.utils.DataWrapper
import java.util.*
import javax.inject.Inject

@ActivityScope
class HomeViewModel @Inject constructor(private val xpnsRepository: XpnsRepository, private val resourceProvider: ThemeSwitcherDialogFragment) : BaseViewModel() {
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


