package com.xpns.injection.builder

import com.xpns.injection.scope.ActivityScope
import com.xpns.injection.scope.FragmentScope
import com.xpns.ui.addxpns.DetailFragment
import com.xpns.ui.addxpns.DetailFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(
            modules = [(DetailFragmentModule::class)])
    internal abstract fun bindXpnsActivity(): DetailFragment
}
