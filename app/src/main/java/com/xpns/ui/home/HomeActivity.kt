package com.xpns.ui.home

import android.content.Context
import android.os.Bundle
import android.os.PowerManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.xpns.R
import com.xpns.databinding.ActivityHomeBinding
import com.xpns.ui.base.BaseActivity
import com.xpns.utils.themeswitcher.ThemeOverlayUtils
import com.xpns.utils.XpnsPreferences
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override fun getViewModelClass() = HomeViewModel::class.java

    override fun layoutId() = R.layout.activity_home

    override fun onSupportNavigateUp() = findNavController(this, R.id.navHostFragment).navigateUp()

    @Inject
    lateinit var prefs: XpnsPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeOverlayUtils.applyThemeOverlays(this)
        super.onCreate(savedInstanceState)
        binding.fab.setOnClickListener { findNavController(this, R.id.navHostFragment).navigate(R.id.actionXpnsFragment) }
    }

    private fun updateNightMode() {
        when (prefs.darkModePreference) {
            XpnsPreferences.DarkMode.ALWAYS -> delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else -> updateNightModeForBatterySaver()
        }
    }

    private fun updateNightModeForBatterySaver() {
        val darkMode = prefs.darkModePreference
        val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
        if (pm.isPowerSaveMode) {
            if (darkMode == XpnsPreferences.DarkMode.BATTERY_SAVER_ONLY || darkMode == XpnsPreferences.DarkMode.AUTO) {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        } else {
            if (darkMode == XpnsPreferences.DarkMode.AUTO) {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
            } else if (darkMode == XpnsPreferences.DarkMode.BATTERY_SAVER_ONLY) {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }
}