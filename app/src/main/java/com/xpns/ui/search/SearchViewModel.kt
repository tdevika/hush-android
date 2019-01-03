package com.xpns.ui.search

import androidx.databinding.ObservableField
import com.xpns.data.repository.GithubRepository
import com.xpns.injection.scope.ActivityScope
import com.xpns.ui.base.BaseViewModel
import javax.inject.Inject


@ActivityScope
class SearchViewModel @Inject constructor(private val githubRepository: GithubRepository) : BaseViewModel() {
    var amount: ObservableField<String> = ObservableField()
    var category: String = ""

    fun onCategoryItemClick(item: String) {
        category = item
    }

    fun onSubmit() {
        githubRepository.saveExpens(amount.get()!!, category)
    }
}


