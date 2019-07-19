package com.hush.data.repository

import androidx.lifecycle.MutableLiveData
import com.hush.data.model.HushItems
import com.hush.data.services.ApiService
import com.hush.utils.CompositeDisposableProvider
import com.hush.utils.DataWrapper
import com.hush.utils.onBackground
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class XpnsRepository @Inject constructor(private val apiService: ApiService,
                                         private val disposableProvider: CompositeDisposableProvider) : BaseRepository(disposableProvider) {

    fun saveExpens(amount: String, expenseCategory: String, date: String, note: String, repositoriesLiveData: MutableLiveData<DataWrapper<String>>) {
        disposableProvider.get().add(apiService.saveExpns(amount, expenseCategory, date, note)
                .onBackground()
                .subscribe({ response ->
                    repositoriesLiveData.postValue(DataWrapper(data = response))
                }, {
                    repositoriesLiveData.postValue(DataWrapper(isError = true, errorMessage = it.message!!))
                }))
    }

    fun getExpenses(repositoriesLiveData: MutableLiveData<DataWrapper<HushItems>>) {
        disposableProvider.get().add(apiService.getExpenses()
                .onBackground()
                .subscribe({ response ->
                    repositoriesLiveData.postValue(DataWrapper(data = response))
                }, {
                    repositoriesLiveData.postValue(DataWrapper(isError = true, errorMessage = it.message!!))
                }))
    }
}
