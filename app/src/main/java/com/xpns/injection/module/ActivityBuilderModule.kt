package com.xpns.injection.module

import com.xpns.injection.scope.ActivityScope
import com.xpns.ui.detail.DetailActivity
import com.xpns.ui.detail.DetailActivityModule
import com.xpns.ui.search.SearchActivity
import com.xpns.ui.search.SearchActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity


@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(
            modules = [(SearchActivityModule::class)])
    internal abstract fun bindSearchActivity(): SearchActivity

    @ActivityScope
    @ContributesAndroidInjector(
            modules = [(DetailActivityModule::class)])
    internal abstract fun bindDetailActivity(): DetailActivity
}


@Module
abstract class BaseActivityModule<in T : DaggerAppCompatActivity>