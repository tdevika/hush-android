package com.hush.injection.component

import com.hush.HushApplication
import com.hush.injection.builder.ActivityBuilder
import com.hush.injection.module.AppModule
import com.hush.injection.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [(AppModule::class),
            (ViewModelModule::class),
            (AndroidSupportInjectionModule::class),
            (ActivityBuilder::class)])
interface AppComponent : AndroidInjector<HushApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<HushApplication>()
}
