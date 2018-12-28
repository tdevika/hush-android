package com.xpns.data.repository

import com.xpns.utils.CompositeDisposableProvider

open class BaseRepository constructor(private val compositeDisposableProvider: CompositeDisposableProvider) {

    fun dispose() {
        compositeDisposableProvider.dispose()
    }
}