package com.xpns.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xpns.injection.scope.ViewModelScope
import com.xpns.ui.home.HomeViewModel
import com.xpns.ui.xpns.XpnsFragmentViewModel
import com.xpns.ui.xpnslist.XpnsListFragmentViewModel
import com.xpns.utils.ViewModelFactory
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
    @ViewModelScope(XpnsListFragmentViewModel::class)
    abstract fun bindDetailFragmentViewModel(xpnsListFragmentViewModel: XpnsListFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(XpnsFragmentViewModel::class)
    abstract fun bindXpnsFragmentViewModel(xpnsFragmentViewModel: XpnsFragmentViewModel): ViewModel


    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
