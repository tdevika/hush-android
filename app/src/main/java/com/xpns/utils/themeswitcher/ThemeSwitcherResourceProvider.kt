package com.xpns.utils.themeswitcher

import com.xpns.R

import androidx.annotation.ArrayRes

/** A helper class that facilitates overriding of theme switcher resources in the Catalog app.  */
class ThemeSwitcherResourceProvider {

    val primaryColors: Int @ArrayRes get() = R.array.mtrl_primary_palettes

    val secondaryColors: Int @ArrayRes get() = R.array.mtrl_secondary_palettes

    val primaryColorsContentDescription: Int @ArrayRes get() = R.array.mtrl_palettes_content_description

    val secondaryColorsContentDescription: Int @ArrayRes get() = R.array.mtrl_palettes_content_description
}
