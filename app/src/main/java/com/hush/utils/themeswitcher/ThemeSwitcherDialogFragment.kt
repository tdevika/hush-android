package com.hush.utils.themeswitcher

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioGroup
import androidx.annotation.ArrayRes
import androidx.annotation.ColorInt
import androidx.annotation.StyleRes
import androidx.annotation.StyleableRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.widget.CompoundButtonCompat
import com.hush.R

/**
 * Theme switcher dialog that allows the user to choose a primary or secondary palette to overlay
 * above the app theme.
 */
class ThemeSwitcherDialogFragment : AppCompatDialogFragment() {

    private val resourceProvider: ThemeSwitcherResourceProvider = ThemeSwitcherResourceProvider()
    private var primaryGroup: RadioGroup? = null
    private var secondaryGroup: RadioGroup? = null

    override fun onCreateDialog(bundle: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)
        builder.setTitle(R.string.mtrl_theme_switcher_title)
                .setView(onCreateDialogView(activity!!.layoutInflater))
                .setPositiveButton(R.string.mtrl_theme_switcher_save) { dialog, which ->
                    dialog.dismiss()
                    applyThemeOverlays()
                }
                .setNegativeButton(R.string.mtrl_theme_switcher_cancel, null)
                .setNeutralButton(R.string.mtrl_theme_switcher_reset) { dialog, which ->
                    dialog.dismiss()
                    ThemeOverlayUtils.setThemeOverlays(activity!!, 0, 0)
                }
        return builder.create()
    }

    private fun onCreateDialogView(layoutInflater: LayoutInflater): View {
        val view = layoutInflater.inflate(R.layout.mtrl_theme_switcher_dialog, null)

        val currentThemeOverlays = ThemeOverlayUtils.themeOverlays

        primaryGroup = view.findViewById(R.id.primary_colors)
        initializeColors(
                primaryGroup,
                resourceProvider.primaryColors,
                resourceProvider.primaryColorsContentDescription,
                PRIMARY_THEME_OVERLAY_ATTRS,
                if (currentThemeOverlays.size >= 2) currentThemeOverlays[0] else 0)

        secondaryGroup = view.findViewById(R.id.secondary_colors)
        initializeColors(
                secondaryGroup,
                resourceProvider.secondaryColors,
                resourceProvider.secondaryColorsContentDescription,
                SECONDARY_THEME_OVERLAY_ATTRS,
                if (currentThemeOverlays.size >= 2) currentThemeOverlays[1] else 0)

        return view
    }

    private fun applyThemeOverlays() {
        ThemeOverlayUtils.setThemeOverlays(activity!!, getThemeOverlayResId(primaryGroup!!), getThemeOverlayResId(secondaryGroup!!))
    }

    private fun getThemeOverlayResId(radioGroup: RadioGroup): Int {
        if (radioGroup.checkedRadioButtonId == View.NO_ID) {
            return 0
        } else {
            val colorPalette = dialog.findViewById<View>(radioGroup.checkedRadioButtonId).tag as ColorPalette
            return colorPalette.themeOverlay
        }
    }

    private fun initializeColors(
            group: RadioGroup?,
            @ArrayRes colors: Int,
            @ArrayRes colorContentDescriptions: Int,
            @StyleableRes themeOverlayAttrs: IntArray,
            @StyleRes currentThemeOverlay: Int) {
        val colorsArray = resources.obtainTypedArray(colors)
        val contentDescriptionArray = resources.obtainTypedArray(colorContentDescriptions)
        if (colorsArray.length() != contentDescriptionArray.length()) {
            throw IllegalArgumentException(
                    "Color array length doesn't match its content description array length.")
        }

        for (i in 0 until colorsArray.length()) {
            @StyleRes val paletteThemeOverlay = colorsArray.getResourceId(i, 0)
            val palette = ColorPalette(paletteThemeOverlay, themeOverlayAttrs)

            val button = AppCompatRadioButton(context!!)
            CompoundButtonCompat.setButtonTintList(
                    button, ColorStateList.valueOf(convertToDisplay(palette.main)))
            button.tag = palette
            button.contentDescription = contentDescriptionArray.getString(i)

            group!!.addView(button)

            if (palette.themeOverlay == currentThemeOverlay) {
                group.check(button.id)
            }
        }

        colorsArray.recycle()
    }

    @ColorInt
    private fun convertToDisplay(@ColorInt color: Int): Int {
        return if (color == Color.WHITE) Color.BLACK else color
    }

    private inner class ColorPalette @SuppressLint("ResourceType")
    constructor(@param:StyleRes @field:StyleRes val themeOverlay: Int, @StyleableRes themeOverlayAttrs: IntArray) {

        @ColorInt
        val main: Int
        @ColorInt
        val dark: Int

        init {

            val a = context!!.obtainStyledAttributes(themeOverlay, themeOverlayAttrs)
            main = a.getColor(0, Color.TRANSPARENT)
            dark = if (themeOverlayAttrs.size > 1) a.getColor(1, Color.TRANSPARENT) else Color.TRANSPARENT

            a.recycle()
        }
    }

    companion object {

        @StyleableRes
        private val PRIMARY_THEME_OVERLAY_ATTRS = intArrayOf(R.attr.colorPrimary, R.attr.colorPrimaryDark)

        @StyleableRes
        private val SECONDARY_THEME_OVERLAY_ATTRS = intArrayOf(R.attr.colorSecondary)
    }
}
