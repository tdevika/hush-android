package com.xpns.injection.builder

import com.xpns.injection.scope.ActivityScope
import com.xpns.ui.home.HomeActivity
import com.xpns.ui.home.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity


@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(
            modules = [(HomeActivityModule::class), (FragmentBuilder::class)])
    internal abstract fun bindHomeActivity(): HomeActivity
}


@Module
abstract class BaseActivityModule<in T : DaggerAppCompatActivity>