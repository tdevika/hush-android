package com.xpns.utils

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.xpns.R


object BindingAdapters {

    @BindingAdapter(value = ["bind:imageUrl", "bind:circleCrop"], requireAll = false)
    @JvmStatic
    fun bindImageUrl(view: ImageView, url: String, circleCrop: Boolean) {
        val context = view.context
        if (circleCrop) {
            Glide.with(context)
                    .load(url)
                    .apply(RequestOptions().circleCrop().override(context.resources.getDimensionPixelSize(R.dimen.dp56)).placeholder(R.drawable.ic_account))
                    .into(view)
        } else {
            Glide.with(context)
                    .load(url)
                    .into(view)
        }
    }
}
