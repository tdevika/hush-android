package com.hush.injection.builder

import com.hush.ui.hush.HushFragment
import com.hush.ui.hush.HushFragmentModule
import com.hush.ui.hushlist.HushListFragment
import com.hush.ui.hushlist.HushListFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(
            modules = [(HushListFragmentModule::class)])
    internal abstract fun bindHushListFragmentModule(): HushListFragment

    @ContributesAndroidInjector(
            modules = [(HushFragmentModule::class)])
    internal abstract fun bindHushActivity(): HushFragment
}
