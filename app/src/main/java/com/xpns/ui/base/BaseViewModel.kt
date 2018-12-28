package com.xpns.ui.base

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    val loader: ObservableField<Boolean> = ObservableField()
    val errorMessage: ObservableField<String> = ObservableField()
    val isError: ObservableField<Boolean> = ObservableField()

    fun displayLoader(show: Boolean) {
        loader.set(show)
    }

    fun setErrorMessage(show: Boolean, msg: String) {
        isError.set(show)
        errorMessage.set(msg)
    }

}