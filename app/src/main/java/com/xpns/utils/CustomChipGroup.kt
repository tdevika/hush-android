package com.xpns.utils

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.xpns.R


class CustomChipGroup @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ChipGroup(context, attrs, defStyleAttr) {

    private val categoryList: ArrayList<String> = arrayListOf()

    init {
        isSingleSelection = true
        categoryList.addAll(context.resources.getStringArray(R.array.categories))
        addChip(context)
    }

    fun addChip(context: Context) {
        categoryList.forEach {
            val chip = Chip(context)
            chip.chipBackgroundColor=ContextCompat.getColorStateList(context, R.color.chip_background_color)
            chip.isClickable=true
            chip.isCheckable=true
            chip.text = it
            addView(chip)
        }
    }
}