package com.hush.data.repository

import androidx.lifecycle.MutableLiveData
import com.hush.data.model.Portfolio
import com.hush.data.services.ApiService
import com.hush.utils.CompositeDisposableProvider
import com.hush.utils.DataWrapper
import com.hush.utils.onBackground
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HushRepository @Inject constructor(private val apiService: ApiService,
                                         private val disposableProvider: CompositeDisposableProvider) : BaseRepository(disposableProvider) {


    fun getPortfolio(repositoriesLiveData: MutableLiveData<DataWrapper<List<Portfolio>>>) {
        disposableProvider.get().add(apiService.getPortfolio()
                .onBackground()
                .subscribe({ response ->
                    repositoriesLiveData.postValue(DataWrapper(data = response))
                }, {
                    repositoriesLiveData.postValue(DataWrapper(isError = true, errorMessage = it.message!!))
                }))
    }
}
