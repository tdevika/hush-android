package com.hush

import com.hush.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class HushApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<HushApplication> = DaggerAppComponent.builder().create(this)
}
