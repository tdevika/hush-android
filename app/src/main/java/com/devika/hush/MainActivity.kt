package com.devika.hush

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.devika.hush.ui.portfolio.PortfolioFragment
import com.devika.hush.ui.stocks.StocksFragment
import com.devika.hush.ui.watchlist.WatchListFragment
import com.devika.hush.utilities.DepthPageTransformer
import kotlinx.android.synthetic.main.app_bar_main_layout.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var depthPageTransformer: DepthPageTransformer

    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as HushApplication).appComponent.inject(this)
        setContentView(R.layout.activity_main)
        setUI()
    }

    private fun setUI() {
        setSupportActionBar(toolbar)
        setSideDrawer()
        setViewPager()
    }

    private fun setViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PortfolioFragment(), "PORTFOLIO")
        adapter.addFragment(WatchListFragment(), "WISHLIST")
        adapter.addFragment(StocksFragment(), "STOCKS")
        viewpager.setPageTransformer(true, depthPageTransformer)
        viewpager.adapter = adapter
        tabLayout.setupWithViewPager(viewpager)
    }

    private fun setSideDrawer() {
//        val navController = this.findNavController(R.id.nav_host_fragment)
//        NavigationUI.setupActionBarWithNavController(this, navController, drawer)
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.home,
//                R.id.setting
//            ), drawer
//        )
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        nav_view.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
