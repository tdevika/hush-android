package com.hush.ui.home

import android.content.Context
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.os.PowerManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation.findNavController
import com.hush.R
import com.hush.databinding.ActivityHomeBinding
import com.hush.ui.base.BaseActivity
import com.hush.utils.HushPreferences
import com.hush.utils.themeswitcher.ThemeOverlayUtils
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {


    override fun getViewModelClass() = HomeViewModel::class.java

    override fun layoutId() = R.layout.activity_home

    override fun onSupportNavigateUp() = findNavController(this, R.id.navHostFragment).navigateUp()

    @Inject
    lateinit var prefs: HushPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeOverlayUtils.applyThemeOverlays(this)
        super.onCreate(savedInstanceState)
        var navController = findNavController(this, R.id.navHostFragment)
        binding.fab.setOnClickListener {
            when {
                navController.graph.startDestination == navController.currentDestination?.id -> {
                    binding.fab.setImageResource(R.drawable.icn_morph)
                    (binding.fab.drawable as Animatable).start()
                    findNavController(this, R.id.navHostFragment).navigate(R.id.actionXpnsFragment)
                }
                else -> {
                    binding.fab.setImageResource(R.drawable.icn_morph_reverse)
                    (binding.fab.drawable as Animatable).start()
                    findNavController(this, R.id.navHostFragment).navigateUp()
                }
            }
        }
    }

    private fun updateNightMode() {
        when (prefs.darkModePreference) {
            HushPreferences.DarkMode.ALWAYS -> delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else -> updateNightModeForBatterySaver()
        }
    }

    private fun updateNightModeForBatterySaver() {
        val darkMode = prefs.darkModePreference
        val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
        if (pm.isPowerSaveMode) {
            if (darkMode == HushPreferences.DarkMode.BATTERY_SAVER_ONLY || darkMode == HushPreferences.DarkMode.AUTO) {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        } else {
            if (darkMode == HushPreferences.DarkMode.AUTO) {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
            } else if (darkMode == HushPreferences.DarkMode.BATTERY_SAVER_ONLY) {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }
}