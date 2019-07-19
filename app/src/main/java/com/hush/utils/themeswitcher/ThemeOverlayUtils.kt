package com.hush.utils.themeswitcher

import android.app.Activity
import androidx.annotation.StyleRes
import java.util.Arrays

object ThemeOverlayUtils {

    @StyleRes
    @get:StyleRes
    var themeOverlays = IntArray(0)
        private set

    fun setThemeOverlays(activity: Activity, @StyleRes vararg themeOverlays: Int) {
        if (!Arrays.equals(ThemeOverlayUtils.themeOverlays, themeOverlays)) {
            ThemeOverlayUtils.themeOverlays = themeOverlays
            activity.recreate()
        }
    }

    fun clearThemeOverlays(activity: Activity) {
        setThemeOverlays(activity)
    }

    fun applyThemeOverlays(activity: Activity) {
        for (themeOverlay in themeOverlays) {
            activity.setTheme(themeOverlay)
        }
    }
}
