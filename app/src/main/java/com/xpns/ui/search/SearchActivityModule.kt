package com.xpns.ui.search

import com.xpns.injection.module.BaseActivityModule
import dagger.Module
import dagger.Provides

@Module(includes = [BaseActivityModule::class])
class SearchActivityModule {

    @Provides
    fun provideLinearLayoutManager(activity: SearchActivity): androidx.recyclerview.widget.LinearLayoutManager {
        return androidx.recyclerview.widget.LinearLayoutManager(activity)
    }
}