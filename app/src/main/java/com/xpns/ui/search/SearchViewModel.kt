package com.xpns.ui.search

import androidx.databinding.ObservableField
import com.xpns.data.repository.GithubRepository
import com.xpns.injection.scope.ActivityScope
import com.xpns.ui.base.BaseViewModel
import javax.inject.Inject


@ActivityScope
class SearchViewModel @Inject constructor(private val githubRepository: GithubRepository) : BaseViewModel() {
    var amount: ObservableField<String> = ObservableField()
    var categoryPosition: ObservableField<Int> = ObservableField()
    var category = arrayOf("Food Drinks", "Health/medical", "Clothes shoes", "Transportation", "Gifts","Utilities","Travel","Debt","Other","Housing","Investments")

    fun onSubmit() {
        githubRepository.saveExpens(amount.get()!!,category[categoryPosition.get()!!])
    }
}


