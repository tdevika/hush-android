package com.xpns.data.repository

import androidx.lifecycle.MutableLiveData
import com.xpns.data.model.RepositoriesResponse
import com.xpns.data.model.Subscribers
import com.xpns.data.services.ApiService
import com.xpns.utils.CompositeDisposableProvider
import com.xpns.utils.DataWrapper
import com.xpns.utils.onBackground
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository @Inject constructor(private val apiService: ApiService,
                                           private val disposableProvider: CompositeDisposableProvider) : BaseRepository(disposableProvider) {

    fun searchRepository(query: String,
                         repositoriesLiveData: MutableLiveData<DataWrapper<RepositoriesResponse>>) {
        disposableProvider.get().add(apiService.searchRepository(query)
                .onBackground()
                .subscribe({ response ->
                    repositoriesLiveData.postValue(DataWrapper(data = response))
                }, {
                    repositoriesLiveData.postValue(DataWrapper(isError = true, errorMessage = it.message!!))
                }))
    }

    fun fetchRepositorySubscribers(url: String,
                                   subscribersLiveData: MutableLiveData<DataWrapper<List<Subscribers>>>) {
        disposableProvider.get().add(apiService.fetchRepositorySubscribers(url)
                .onBackground()
                .subscribe({ response ->
                    subscribersLiveData.postValue(DataWrapper(data = response))
                }, {
                    subscribersLiveData.postValue(DataWrapper(isError = true, errorMessage = it.message!!))
                }))
    }

    fun saveExpens(amount: String, expenseCategory: String) {
        disposableProvider.get().add(apiService.saveExpens(amount,expenseCategory)
                .onBackground()
                .subscribe({ response ->
                }, {
                }))
    }

}
