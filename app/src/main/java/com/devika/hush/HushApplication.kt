package com.devika.hush

import android.app.Application
import com.devika.hush.data.services.ApiService
import com.devika.hush.injection.component.AppComponent
import com.devika.hush.injection.component.DaggerAppComponent
import retrofit2.Retrofit
import javax.inject.Inject

class HushApplication @Inject constructor(): Application() {

    val appComponent: AppComponent by lazy {
        intializeComponent()
    }

    init {

    }

    private fun intializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }

}
