package com.devika.hush

import android.app.Application
import com.devika.hush.data.repository.HushRepository
import com.devika.hush.injection.component.AppComponent
import com.devika.hush.injection.component.DaggerAppComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class HushApplication : Application() {

    @Inject
    lateinit var hushRepository: HushRepository

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        CoroutineScope(Dispatchers.IO).launch {
            hushRepository.initDB()
        }
    }
}
