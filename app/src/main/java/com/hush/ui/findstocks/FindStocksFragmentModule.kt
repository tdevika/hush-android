package com.hush.ui.findstocks

import com.hush.data.model.Portfolio
import dagger.Module
import dagger.Provides

@Module
class FindStocksFragmentModule {
    @Provides
    fun findStocksListAdapter(): FindStocksAdapter {
        return FindStocksAdapter(arrayListOf())
    }
}