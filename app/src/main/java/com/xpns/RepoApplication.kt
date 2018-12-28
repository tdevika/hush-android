package com.xpns

import com.xpns.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class RepoApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<RepoApplication> = DaggerAppComponent.builder().create(this)
}
