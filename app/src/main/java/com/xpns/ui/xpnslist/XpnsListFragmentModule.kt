package com.xpns.ui.xpnslist

import androidx.recyclerview.widget.LinearLayoutManager
import com.xpns.ui.home.HomeActivity
import dagger.Module
import dagger.Provides

@Module
class XpnsListFragmentModule{
    @Provides
    fun provideHomeListAdapter(): XpnsListAdapter {
        return XpnsListAdapter(emptyList())
    }

    @Provides
    fun provideLinearLayoutManager(activity: HomeActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }
}