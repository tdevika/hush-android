package com.hush.utils

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class HushPreferences @Inject constructor(
    @Named("app") private val sharedPreferences: SharedPreferences
) {
    companion object {
        const val KEY_DARK_MODE = "pref_dark_mode"
    }

    enum class DarkMode(val value: String) {
        SYSTEM("system"),
        AUTO("auto"),
        BATTERY_SAVER_ONLY("battery"),
        ALWAYS("always")
    }

    val darkModePreference: DarkMode
        get() = uiThemeFromPref(sharedPreferences.getString(KEY_DARK_MODE, null))

    private fun uiThemeFromPref(value: String?): DarkMode {
        return DarkMode.values().firstOrNull { it.value == value } ?: DarkMode.SYSTEM
    }
}
