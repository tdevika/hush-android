package com.xpns.injection.builder

import com.xpns.ui.xpns.XpnsFragment
import com.xpns.ui.xpns.XpnsFragmentModule
import com.xpns.ui.xpnslist.XpnsListFragment
import com.xpns.ui.xpnslist.XpnsListFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(
            modules = [(XpnsListFragmentModule::class)])
    internal abstract fun bindXpnsListFragmentModule(): XpnsListFragment

    @ContributesAndroidInjector(
            modules = [(XpnsFragmentModule::class)])
    internal abstract fun bindXpnsActivity(): XpnsFragment
}
