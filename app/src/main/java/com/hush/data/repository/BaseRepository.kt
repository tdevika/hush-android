package com.hush.data.repository

import com.hush.utils.CompositeDisposableProvider

open class BaseRepository constructor(private val compositeDisposableProvider: CompositeDisposableProvider) {

    fun dispose() {
        compositeDisposableProvider.dispose()
    }
}