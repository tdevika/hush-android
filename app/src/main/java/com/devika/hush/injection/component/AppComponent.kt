package com.devika.hush.injection.component

import android.content.Context
import com.devika.hush.HushApplication
import com.devika.hush.MainActivity
import com.devika.hush.injection.module.ActivityModule
import com.devika.hush.injection.module.AppModule
import com.devika.hush.injection.module.NetWorkModule
import com.devika.hush.ui.portfolio.PortfolioFragment
import com.devika.hush.ui.stocks.StocksFragment
import com.devika.hush.ui.watchlist.WatchListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetWorkModule::class, ActivityModule::class, AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: HushApplication): AppComponent
    }
    fun inject(application: HushApplication)
    fun inject(activity: MainActivity)
    fun inject(fragment: PortfolioFragment)
    fun inject(fragment: StocksFragment)
    fun inject(fragment: WatchListFragment)
}