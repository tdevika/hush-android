package com.hush.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hush.injection.scope.ViewModelScope
import com.hush.ui.findstocks.FindStocksFragmentViewModel
import com.hush.ui.home.HomeViewModel
import com.hush.ui.hush.HushFragmentViewModel
import com.hush.ui.hushlist.HushListFragmentViewModel
import com.hush.ui.watchList.WatchlistFragmentViewModel
import com.hush.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelScope(HomeViewModel::class)
    abstract fun bindHomeModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(HushListFragmentViewModel::class)
    abstract fun bindDetailFragmentViewModel(hushListFragmentViewModel: HushListFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(HushFragmentViewModel::class)
    abstract fun bindHushFragmentViewModel(hushFragmentViewModel: HushFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(WatchlistFragmentViewModel::class)
    abstract fun bindWatchListFragmentViewModel(watchlistFragmentViewModel: WatchlistFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(
        FindStocksFragmentViewModel::class
    )
    abstract fun bindFindStocksViewModel(findStocksViewModel: FindStocksFragmentViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
