package com.devika.hush.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {
    protected val uiState: MutableLiveData<T> = MutableLiveData()
    fun uiState(): LiveData<T> = uiState
}