package com.devika.hush.injection.component

import com.devika.hush.HushApplication
import com.devika.hush.injection.module.ActivityModule
import com.devika.hush.injection.module.AppModule
import com.devika.hush.injection.module.CoroutinesModule
import com.devika.hush.injection.module.FragmentModule
import com.devika.hush.injection.module.NetworkModule
import com.devika.hush.injection.module.ViewModelModule
import com.devika.hush.ui.home.HomeActivity
import com.devika.hush.ui.home.equities.EquitiesFragment
import com.devika.hush.ui.home.equities.portfolio.PortfolioFragment
import com.devika.hush.ui.home.equities.stocks.StocksFragment
import com.devika.hush.ui.home.equities.watchlist.WatchListFragment
import com.devika.hush.ui.home.explore.ExploreFragment
import com.devika.hush.ui.home.info.InfoFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        CoroutinesModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: HushApplication): AppComponent
    }

    fun inject(application: HushApplication)
    fun inject(activity: HomeActivity)
    fun inject(fragment: EquitiesFragment)
    fun inject(fragment: ExploreFragment)
    fun inject(fragment: InfoFragment)
    fun inject(fragment: PortfolioFragment)
    fun inject(fragment: StocksFragment)
    fun inject(fragment: WatchListFragment)
}
