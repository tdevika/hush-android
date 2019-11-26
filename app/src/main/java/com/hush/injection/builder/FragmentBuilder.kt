package com.hush.injection.builder

import com.hush.ui.findstocks.FindStocksFragment
import com.hush.ui.findstocks.FindStocksFragmentModule
import com.hush.ui.hush.HushFragment
import com.hush.ui.hush.HushFragmentModule
import com.hush.ui.hushlist.HushListFragment
import com.hush.ui.hushlist.HushListFragmentModule
import com.hush.ui.portfolio.PortfolioFragment
import com.hush.ui.portfolio.PortfolioFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(
        modules = [(HushListFragmentModule::class)]
    )
    internal abstract fun bindHushListFragmentModule(): HushListFragment

    @ContributesAndroidInjector(
        modules = [(HushFragmentModule::class)]
    )
    internal abstract fun bindHushFragmentModule(): HushFragment

    @ContributesAndroidInjector(
        modules = [(PortfolioFragmentModule::class)]
    )
    internal abstract fun bindHPortfolioFragmentModule(): PortfolioFragment

    @ContributesAndroidInjector(
        modules = [(FindStocksFragmentModule::class)]
    )
    internal abstract fun bindFindStocksFragmentModule(): FindStocksFragment
}
