package com.xpns.injection.component

import com.xpns.XpnsApplication
import com.xpns.injection.module.ActivityBuilderModule
import com.xpns.injection.module.AppModule
import com.xpns.injection.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [(AppModule::class),
            (ViewModelModule::class),
            (AndroidSupportInjectionModule::class),
            (ActivityBuilderModule::class)])
interface AppComponent : AndroidInjector<XpnsApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<XpnsApplication>()
}
