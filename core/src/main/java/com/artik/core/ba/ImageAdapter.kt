package com.artik.core.ba

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageAdapter {
    @BindingAdapter(
        value = [
            "app:url",
            "app:placeholder"
        ],
        requireAll = false
    )
    @JvmStatic
    fun applyImage(
        view: AppCompatImageView,
        url: String?,
        placeholder: Drawable
    ) {
        view.setImageDrawable(placeholder)

        url?.let {
            Glide.with(view).load(it).into(view)
        }
    }
}