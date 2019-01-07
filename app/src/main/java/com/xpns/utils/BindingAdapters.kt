package com.xpns.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.bumptech.glide.Glide


object BindingAdapters {

    @BindingAdapter(value = ["bind:imageUrl", "bind:circleCrop"], requireAll = false)
    @JvmStatic
    fun bindImageUrl(view: ImageView, url: String, circleCrop: Boolean) {
        val context = view.context
        if (circleCrop) {
            Glide.with(context)
                    .load(url)
                    .into(view)
        } else {
            Glide.with(context)
                    .load(url)
                    .into(view)
        }
    }

    @BindingAdapter(value = ["bind:category"])
    @JvmStatic
    fun bindChipGroupSelection(customChipGroup: CustomChipGroup, category: ObservableField<String>) {
        customChipGroup.setOnCheckedChangeListener { chipGroup, id ->
            category.set(customChipGroup.getCheckedChip(chipGroup.checkedChipId))
        }
    }
}
