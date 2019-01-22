package com.xpns.ui.xpnslist

import dagger.Module
import dagger.Provides

@Module
class XpnsListFragmentModule {
    @Provides
    fun provideHomeListAdapter(): XpnsListAdapter {
        return XpnsListAdapter(emptyList())
    }
}