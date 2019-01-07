package com.xpns.utils

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
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

//    private fun addChip(context: Context) {
//        val inflater = LayoutInflater.from(context)
//        categoryList.forEach {
//            val chip =inflater.inflate(R.layout.view_choice_chip, this@CustomChipGroup, false) as Chip
//            chip.text = it
//            addView(chip)
//        }
//    }

    private fun addChip(context: Context) {
        categoryList.forEach {
            val chip = Chip(context)
            chip.chipBackgroundColor=ContextCompat.getColorStateList(context, R.color.chip_background_color)
            chip.chipIcon = ContextCompat.getDrawable(context, R.drawable.ic_placeholder_circle)
            chip.chipIconTint = ContextCompat.getColorStateList(context, android.R.color.white)
            chip.isClickable=true
            chip.isCheckable=true
            chip.ellipsize=TextUtils.TruncateAt.END_SMALL
            chip.text = it
            addView(chip)
        }
    }

    fun getCheckedChip(checkedChipId: Int): String {
           return categoryList[checkedChipId]
    }
}