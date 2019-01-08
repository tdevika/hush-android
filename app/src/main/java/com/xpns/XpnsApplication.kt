package com.xpns

import com.xpns.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class XpnsApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<XpnsApplication> = DaggerAppComponent.builder().create(this)
}
