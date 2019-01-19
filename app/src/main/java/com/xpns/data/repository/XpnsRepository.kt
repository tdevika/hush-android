package com.xpns.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.xpns.data.model.XpnsItems
import com.xpns.data.services.ApiService
import com.xpns.utils.CompositeDisposableProvider
import com.xpns.utils.DataWrapper
import com.xpns.utils.onBackground
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

    fun getExpenses(repositoriesLiveData: MutableLiveData<DataWrapper<XpnsItems>>) {
        disposableProvider.get().add(apiService.getExpenses()
                .onBackground()
                .subscribe({ response ->
                    repositoriesLiveData.postValue(DataWrapper(data = response))
                }, {
                    repositoriesLiveData.postValue(DataWrapper(isError = true, errorMessage = it.message!!))
                }))
    }
}
