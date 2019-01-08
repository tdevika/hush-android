package com.xpns.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xpns.injection.scope.ViewModelScope
import com.xpns.ui.xpns.XpnsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import shekar.com.githubrepositoriessearch.utils.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelScope(XpnsViewModel::class)
    abstract fun bindSearchViewModel(xpnsViewModel: XpnsViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
