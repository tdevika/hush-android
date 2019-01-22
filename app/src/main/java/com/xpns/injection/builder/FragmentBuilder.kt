package com.xpns.injection.builder

import com.xpns.ui.xpnslist.XpnsListFragment
import com.xpns.ui.xpnslist.XpnsListFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(
            modules = [(XpnsListFragmentModule::class)])
    internal abstract fun bindXpnsActivity(): XpnsListFragment
}
