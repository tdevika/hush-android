package com.xpns.injection.module

import com.xpns.injection.scope.ActivityScope
import com.xpns.ui.home.HomeActivity
import com.xpns.ui.home.HomeActivityModule
import com.xpns.ui.xpns.XpnsActivity
import com.xpns.ui.xpns.XpnsActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity


@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(
            modules = [(XpnsActivityModule::class)])
    internal abstract fun bindXpnsActivity(): XpnsActivity

    @ActivityScope
    @ContributesAndroidInjector(
            modules = [(HomeActivityModule::class)])
    internal abstract fun bindHomeActivity(): HomeActivity
}


@Module
abstract class BaseActivityModule<in T : DaggerAppCompatActivity>