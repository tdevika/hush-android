package com.devika.hush.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    protected val uiState: MutableLiveData<BaseState> = MutableLiveData()
    fun uiState(): LiveData<BaseState> = uiState
}
