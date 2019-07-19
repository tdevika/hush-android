package com.hush.injection.builder

import com.hush.injection.scope.ActivityScope
import com.hush.ui.home.HomeActivity
import com.hush.ui.home.HomeActivityModule
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