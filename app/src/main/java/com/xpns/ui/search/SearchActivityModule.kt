package com.xpns.ui.search

import androidx.recyclerview.widget.LinearLayoutManager
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
    fun provideLinearLayoutManager(activity: SearchActivity): androidx.recyclerview.widget.LinearLayoutManager {
        return androidx.recyclerview.widget.LinearLayoutManager(activity)
    }
}