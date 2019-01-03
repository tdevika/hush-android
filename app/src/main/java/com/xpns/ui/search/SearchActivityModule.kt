package com.xpns.ui.search

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xpns.injection.module.BaseActivityModule
import dagger.Module
import dagger.Provides

@Module(includes = [BaseActivityModule::class])
class SearchActivityModule {

    @Provides
    fun provideSearchAdapter(): SearchAdapter {
        return SearchAdapter()
    }

    @Provides
    fun provideLinearLayoutManager(activity: SearchActivity): LinearLayoutManager {
        val layoutManager = GridLayoutManager(activity, 3)
        layoutManager.orientation = GridLayoutManager.HORIZONTAL
        return layoutManager
    }
}