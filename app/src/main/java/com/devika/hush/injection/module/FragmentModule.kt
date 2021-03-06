package com.devika.hush.injection.module

import androidx.lifecycle.ViewModel
import com.devika.hush.injection.scope.ViewModelScope
import com.devika.hush.ui.home.details.DetailsViewModel
import com.devika.hush.ui.home.equities.EquitiesViewModel
import com.devika.hush.ui.home.explore.ExploreViewModel
import com.devika.hush.ui.home.info.InfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentModule {

    @Binds
    @IntoMap
    @ViewModelScope(EquitiesViewModel::class)
    abstract fun bindEquitiesViewModel(equitiesViewModel: EquitiesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(InfoViewModel::class)
    abstract fun bindInfoViewModel(infoViewModel: InfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(ExploreViewModel::class)
    abstract fun bindExploreViewModel(exploreViewModel: ExploreViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(detailsViewModel: DetailsViewModel): ViewModel
}
