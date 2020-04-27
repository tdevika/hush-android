package com.devika.hush

import android.app.Application
import com.devika.hush.injection.component.AppComponent
import com.devika.hush.injection.component.DaggerAppComponent
import timber.log.Timber

class HushApplication : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(this)
    }
}
