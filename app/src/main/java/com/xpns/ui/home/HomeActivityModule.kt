package com.xpns.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.xpns.injection.module.BaseActivityModule
import dagger.Module
import dagger.Provides

@Module(includes = [BaseActivityModule::class])
class HomeActivityModule{
    @Provides
    fun provideHomeListAdapter(): HomeListAdapter {
        return HomeListAdapter(emptyList())
    }

    @Provides
    fun provideLinearLayoutManager(activity: HomeActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }
}