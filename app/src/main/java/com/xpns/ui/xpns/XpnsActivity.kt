package com.xpns.ui.xpns

import android.content.Context
import android.os.Bundle
import android.os.PowerManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.xpns.R
import com.xpns.databinding.ActivityXpnsBinding
import com.xpns.ui.base.BaseActivity
import com.xpns.ui.themeswitcher.ThemeOverlayUtils
import com.xpns.utils.Constants
import com.xpns.utils.DataWrapper
import com.xpns.utils.XpnsPreferences
import javax.inject.Inject

class XpnsActivity : BaseActivity<ActivityXpnsBinding, XpnsViewModel>() {
    @Inject
    lateinit var prefs: XpnsPreferences
    override fun getViewModelClass() = XpnsViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.activity_xpns
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeOverlayUtils.applyThemeOverlays(this)
        super.onCreate(savedInstanceState)
        subscribeToModel()
        updateNightMode()

    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
        viewModel.repositoriesLiveData.observe(this, repositoriesObserver())
        binding.setLifecycleOwner(this)
    }
    private fun repositoriesObserver(): Observer<DataWrapper<String>> {
        return Observer {
            viewModel.displayLoader(false)
            it?.let {
                if (!it.isError) {
                    Toast.makeText(this,"Expense added",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,"Error"+it.errorMessage,Toast.LENGTH_SHORT).show()
                }
            }
        }
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
            // Since we're in battery saver mode,
            if (darkMode == XpnsPreferences.DarkMode.BATTERY_SAVER_ONLY || darkMode == XpnsPreferences.DarkMode.AUTO) {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        } else {
            // If we're not in power saving mode, we can just use the default states
            if (darkMode == XpnsPreferences.DarkMode.AUTO) {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
            } else if (darkMode == XpnsPreferences.DarkMode.BATTERY_SAVER_ONLY) {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }

}