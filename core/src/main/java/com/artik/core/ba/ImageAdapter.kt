package com.artik.core.ba

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageAdapter {
    @BindingAdapter( value = [
        "app:url",
        "app:placeholder"
    ],
        requireAll = false
    )
    @JvmStatic
    fun applyImage(
        view: ImageView,
        url: String,
        placeholder:Drawable?
    ) {
        Glide.with(view).load(url).placeholder(placeholder).into(view)
    }
}