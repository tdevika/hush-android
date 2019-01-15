package com.xpns.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.xpns.R


class CustomChipGroup @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ChipGroup(context, attrs, defStyleAttr) {

    private val categoryList: ArrayList<String> = arrayListOf()

    init {
        isSingleSelection = true
        categoryList.addAll(context.resources.getStringArray(R.array.categories))
        addChip()
    }
    private fun addChip() {
        val inflater = LayoutInflater.from(context)
        categoryList.forEach {
            val chip = inflater.inflate(R.layout.view_choice_chip, this, false) as Chip
            chip.chipIconTint = ContextCompat.getColorStateList(context, android.R.color.white)
            chip.text = it
            addView(chip)
        }
    }
    fun getCheckedChipValue(checkedChipId: Int): String {
        return categoryList[checkedChipId]
    }
}