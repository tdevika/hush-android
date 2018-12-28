package com.xpns.ui.search

import androidx.lifecycle.MutableLiveData
import com.xpns.data.model.RepositoriesResponse
import com.xpns.data.repository.GithubRepository
import com.xpns.injection.scope.ActivityScope
import com.xpns.ui.base.BaseViewModel
import com.xpns.utils.Constants
import com.xpns.utils.DataWrapper
import javax.inject.Inject

@ActivityScope
class SearchViewModel @Inject constructor(private val githubRepository: GithubRepository) : BaseViewModel() {
    var repositoriesLiveData = MutableLiveData<DataWrapper<RepositoriesResponse>>()

    fun searchRepository(query: String) {
        setErrorMessage(false, Constants.EMPTY_MESSAGE)
        displayLoader(true)
        githubRepository.searchRepository(query, repositoriesLiveData)
    }

    override fun onCleared() {
        githubRepository.dispose()
        super.onCleared()
    }

}


