package com.xpns.ui.detail

import android.arch.lifecycle.MutableLiveData
import com.xpns.data.model.Subscribers
import com.xpns.data.repository.GithubRepository
import com.xpns.injection.scope.ActivityScope
import com.xpns.ui.base.BaseViewModel
import com.xpns.utils.Constants
import com.xpns.utils.DataWrapper
import javax.inject.Inject

@ActivityScope
class DetailViewModel @Inject constructor(private val githubRepository: GithubRepository) : BaseViewModel() {

    var subscribersLiveData = MutableLiveData<DataWrapper<List<Subscribers>>>()

    fun fetchRepositorySubscribers(url: String) {
        displayLoader(true)
        setErrorMessage(false, Constants.EMPTY_MESSAGE)
        githubRepository.fetchRepositorySubscribers(url, subscribersLiveData)
    }

    override fun onCleared() {
        githubRepository.dispose()
        super.onCleared()
    }
}


