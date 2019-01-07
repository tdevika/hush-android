package com.xpns.utils

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField


object BindingAdapters {

    @BindingAdapter(value = ["bind:category"])
    @JvmStatic
    fun bindChipGroupSelection(customChipGroup: CustomChipGroup, category: ObservableField<String>) {
        customChipGroup.setOnCheckedChangeListener { chipGroup, id ->
            category.set(customChipGroup.getCheckedChip(chipGroup.checkedChipId))
        }
    }
}
