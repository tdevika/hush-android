package com.hush.ui.home

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.google.android.material.tabs.TabLayout
import com.hush.R
import com.hush.databinding.ActivityHomeBinding
import com.hush.ui.base.BaseActivity
import com.hush.utils.themeswitcher.ThemeOverlayUtils

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {


    override fun getViewModelClass() = HomeViewModel::class.java

    override fun layoutId() = R.layout.activity_home

    override fun onSupportNavigateUp() = findNavController(this, R.id.navHostFragment).navigateUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeOverlayUtils.applyThemeOverlays(this)
        super.onCreate(savedInstanceState)
        var pageAdapter = PageAdapter(supportFragmentManager, binding.tabLayout.getTabCount())
        binding.pager.setAdapter(pageAdapter)
       binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.pager.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        binding.pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))

    }
}