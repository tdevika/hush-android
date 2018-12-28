package com.xpns.ui.search

import android.support.v7.widget.LinearLayoutManager
import com.xpns.injection.module.BaseActivityModule
import dagger.Module
import dagger.Provides

@Module(includes = [BaseActivityModule::class])
class SearchActivityModule {
    @Provides
    fun provideSearchAdapter(searchEventHandler: SearchEventHandler): SearchAdapter {
        return SearchAdapter(emptyList(), searchEventHandler)
    }

    @Provides
    fun provideSearchEventHandler(activity: SearchActivity): SearchEventHandler {
        return SearchEventHandler(activity)
    }

    @Provides
    fun provideLinearLayoutManager(activity: SearchActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }
}