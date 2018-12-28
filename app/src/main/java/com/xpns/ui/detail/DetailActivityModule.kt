package com.xpns.ui.detail

import androidx.recyclerview.widget.LinearLayoutManager
import com.xpns.injection.module.BaseActivityModule
import dagger.Module
import dagger.Provides

@Module(includes = [BaseActivityModule::class])
class DetailActivityModule {
    @Provides
    fun provideDetailAdapter(): DetailAdapter {
        return DetailAdapter(emptyList())
    }

    @Provides
    fun provideDetailEventHandler(activity: DetailActivity): DetailEventHandler {
        return DetailEventHandler(activity)
    }

    @Provides
    fun provideLinearLayoutManager(activity: DetailActivity): androidx.recyclerview.widget.LinearLayoutManager {
        return androidx.recyclerview.widget.LinearLayoutManager(activity)
    }
}