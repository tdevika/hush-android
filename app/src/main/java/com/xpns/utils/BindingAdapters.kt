package com.xpns.utils

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField


object BindingAdapters {

    @BindingAdapter(value = ["app:category"])
    @JvmStatic
    fun bindChipGroupSelection(customChipGroup: CustomChipGroup, category: ObservableField<String>) {
        customChipGroup.setOnCheckedChangeListener { chipGroup, id ->
            if (id == -1) {
                category.set("")
            } else {
                category.set(customChipGroup.getCheckedChip(chipGroup.checkedChipId-1))
            }
        }
    }
}
