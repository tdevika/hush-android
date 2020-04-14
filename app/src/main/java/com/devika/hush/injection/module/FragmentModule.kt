package com.devika.hush.injection.module

import androidx.lifecycle.ViewModel
import com.devika.hush.injection.scope.ViewModelScope
import com.devika.hush.ui.portfolio.PortfolioViewModel
import com.devika.hush.ui.stocks.StocksViewModel
import com.devika.hush.ui.watchlist.WatchListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentModule {

    @Binds
    @IntoMap
    @ViewModelScope(PortfolioViewModel::class)
    abstract fun bindHomeModel(homeViewModel: PortfolioViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(StocksViewModel::class)
    abstract fun bindStockViewModel(homeViewModel: StocksViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(WatchListViewModel::class)
    abstract fun bindWatchListViewModel(homeViewModel: WatchListViewModel): ViewModel
}