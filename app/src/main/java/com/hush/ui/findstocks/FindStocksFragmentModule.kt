package com.hush.ui.findstocks

import dagger.Module
import dagger.Provides

@Module
class FindStocksFragmentModule {
    @Provides
    fun findStocksListAdapter(): FindStocksAdapter {
        return FindStocksAdapter(emptyList())
    }
}