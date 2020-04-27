package com.devika.hush.injection.module

import androidx.lifecycle.ViewModel
import com.devika.hush.injection.scope.ViewModelScope
import com.devika.hush.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ActivityModule {
    @Binds
    @IntoMap
    @ViewModelScope(HomeViewModel::class)
    abstract fun bindHomeModel(homeViewModel: HomeViewModel): ViewModel
}
