package com.xpns.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xpns.injection.scope.ViewModelScope
import com.xpns.ui.addxpns.DetailFragmentModule
import com.xpns.ui.addxpns.DetailFragmentViewModel
import com.xpns.ui.home.HomeViewModel
import com.xpns.ui.xpns.XpnsViewModel
import com.xpns.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelScope(XpnsViewModel::class)
    abstract fun bindXpnsModel(xpnsViewModel: XpnsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(HomeViewModel::class)
    abstract fun bindHomeModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(DetailFragmentViewModel::class)
    abstract fun bindDetailFragmentViewModel(detailFragmentViewModel: DetailFragmentViewModel): ViewModel


    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
