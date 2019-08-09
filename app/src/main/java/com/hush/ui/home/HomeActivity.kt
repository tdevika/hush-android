package com.hush.ui.home

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
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
    }
}