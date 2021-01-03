package com.artik.core.ba

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageAdapter {
    @BindingAdapter("app:url")
    @JvmStatic
    fun applyImage(
        view: ImageView,
        url: String
    ) {
        Glide.with(view).load(url).into(view)
    }
}