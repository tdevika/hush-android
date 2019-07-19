package com.hush.ui.hushlist

import dagger.Module
import dagger.Provides

@Module
class HushListFragmentModule {
    @Provides
    fun provideHomeListAdapter(): HushListAdapter {
        return HushListAdapter(emptyList())
    }
}